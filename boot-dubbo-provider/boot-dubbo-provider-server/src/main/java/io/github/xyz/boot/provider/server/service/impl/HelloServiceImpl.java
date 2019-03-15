/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.provider.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.provider.api.result.Response;
import io.github.xyz.boot.provider.api.service.HelloService;

/**
 * @author sunny
 * @date: 2019-03-15 22:01
 * @des:
 */
@Service(interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public Response<String> say(String name) {
        return new Response<>(0, "ok", "dubbo:"+name);
    }
}
