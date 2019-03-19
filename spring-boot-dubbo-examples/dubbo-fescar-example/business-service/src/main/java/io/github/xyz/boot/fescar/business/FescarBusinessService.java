/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.business;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 14:48
 * @des:
 */
@SpringBootApplication
@EnableDubbo
public class FescarBusinessService {
    public static void main(String[] args) {
        SpringApplication.run(FescarBusinessService.class, args);
    }
}
