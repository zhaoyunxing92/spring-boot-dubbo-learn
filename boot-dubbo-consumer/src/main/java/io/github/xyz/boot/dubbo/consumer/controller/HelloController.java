/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.github.xyz.boot.provider.api.result.Response;
import io.github.xyz.boot.provider.api.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @date: 2019-03-16 01:34
 * @des:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/name")
    Response<String> sayHello(String name) {
        return helloService.say(name);
    }
}
