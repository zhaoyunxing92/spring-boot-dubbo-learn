package io.github.xyz.boot.core.web.config.handler;

import io.github.xyz.boot.core.common.exception.AppGlobalException;
import io.github.xyz.boot.core.common.result.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author sunny
 * @date: 2018-06-08 13:51
 * @des: 统一异常处理
 */
@Order(1)
@ControllerAdvice
public class AppGlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(AppGlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response validExceptionHandle(Exception ex) {

        String message;
        if (ex instanceof BindException) {
            BindException bingException = (BindException) ex;
            message = bingException.getAllErrors().get(0).getDefaultMessage();
        } else if (ex instanceof MethodArgumentNotValidException) {
            // 参数校验不通过
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException) ex;
            message = argumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        } else if (ex instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException notReadableException = (HttpMessageNotReadableException) ex;
            message = notReadableException.getMessage();
        } else if (ex instanceof ConstraintViolationException) {
            //参数校验异常，controller层直接参数校验（单个字段校验）
            ConstraintViolationException validationException = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violationErrors = validationException.getConstraintViolations();
            ConstraintViolation<?> error = violationErrors.iterator().next();
            message = error.getMessage();
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            HttpRequestMethodNotSupportedException methodNotSupportedException = (HttpRequestMethodNotSupportedException) ex;
            message = methodNotSupportedException.getMessage();
        } else if (ex instanceof AppGlobalException) {
            // TODO: 在dubbo里面该异常被包装 自定义异常
            AppGlobalException appGlobalException = (AppGlobalException) ex;
            return appGlobalException.getRes();
        } else {
            message = ex.getMessage();
        }

        logger.error("系统异常500:", ex);
        return new Response<>(500, "系统异常500：", message);
    }
}
