/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.provider.api.service;

import io.github.xyz.boot.provider.api.result.Response;

/**
 * @author sunny
 * @date: 2019-03-15 21:58
 * @des:
 */
public interface HelloService {
    /**
     * @param name
     */
    Response<String> say(String name);
}
