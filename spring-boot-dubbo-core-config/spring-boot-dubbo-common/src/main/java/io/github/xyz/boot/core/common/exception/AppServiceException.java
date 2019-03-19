package io.github.xyz.boot.core.common.exception;

/**
 * @author zhaoyunxing
 * @date: 2018-06-26 16:33
 * @des: 服务模块异常
 */
public class AppServiceException extends AppGlobalException {


    public AppServiceException(String msg) {
        super(msg);
    }

    public AppServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
