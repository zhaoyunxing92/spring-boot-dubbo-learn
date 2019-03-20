/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.business;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import io.github.xyz.boot.core.web.config.ApiCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 14:48
 * @des:
 */
@SpringBootApplication
@EnableDubbo
@Import(ApiCoreConfig.class)
public class FescarBusinessService {
    public static void main(String[] args) {
        SpringApplication.run(FescarBusinessService.class, args);
    }
}
