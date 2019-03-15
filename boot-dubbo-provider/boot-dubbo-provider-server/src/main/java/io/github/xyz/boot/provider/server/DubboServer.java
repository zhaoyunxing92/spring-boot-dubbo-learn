/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.provider.server;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoyunxing
 * @date: 2019-03-15 17:04
 * @des:
 */
@SpringBootApplication
@EnableDubbo
public class DubboServer {
    public static void main(String[] args) {
        SpringApplication.run(DubboServer.class, args);
    }
}