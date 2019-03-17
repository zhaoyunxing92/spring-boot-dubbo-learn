package io.github.xyz.boot.core.common.exception;

/**
 * @author zhaoyunxing
 * @date: 2018-06-26 16:41
 * @des: 控制器层异常
 */
public class AppControllerException extends AppGlobalException {


    public AppControllerException(String msg) {
        super(msg);
    }

    public AppControllerException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
