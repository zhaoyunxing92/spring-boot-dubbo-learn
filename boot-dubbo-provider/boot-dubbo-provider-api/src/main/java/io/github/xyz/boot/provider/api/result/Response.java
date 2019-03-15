/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.provider.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author sunny
 * @date: 2019-03-16 01:08
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
     * 数据
     */
    private T data;
}
