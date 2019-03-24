/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.core.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 15:01
 * @des:
 */
@Data
@AllArgsConstructor
@ToString
public class Response<T extends Serializable> implements Serializable {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 是否成功
     */
    private Boolean succeed;
    /**
     * 数据
     */
    private T data;

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.succeed = false;
        this.data = data;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.succeed = false;
    }

    public Response(Integer code, String msg, Boolean succeed) {
        this.code = code;
        this.msg = msg;
        this.succeed = succeed;
    }
}