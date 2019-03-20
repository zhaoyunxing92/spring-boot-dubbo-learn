package io.github.xyz.boot.core.common.exception;


import io.github.xyz.boot.core.common.result.Response;

/**
 * @author sunny
 * @date: 2018-05-18 13:31
 * @des: 全局异常
 */
public class AppGlobalException extends RuntimeException {
    private static final long serialVersionUID = -4901434558868605358L;

    private Response res;

    public AppGlobalException(String msg) {
        res = new Response<>(500, msg, null);
    }

    public AppGlobalException(String msg, Throwable cause) {
        res = new Response<>(500, msg, cause);
    }

    public Response getRes() {
        return res;
    }
}
