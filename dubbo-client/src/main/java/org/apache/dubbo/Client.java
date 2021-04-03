/**
 * Copyright(C) 2021 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package org.apache.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoyunxing
 * @date: 2021-04-03 02:01
 */
@Slf4j
@SpringBootApplication
public class Client {

    public static void main(String[] args){
         SpringApplication.run(Client.class, args);
    }
}
