/**
 * Copyright(C) 2021 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package org.apache.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoyunxing
 * @date: 2021-04-03 00:52
 */
@SpringBootApplication
public class Provider {

    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
