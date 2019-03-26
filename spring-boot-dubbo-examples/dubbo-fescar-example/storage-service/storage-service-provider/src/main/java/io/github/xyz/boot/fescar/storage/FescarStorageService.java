/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.storage;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import io.github.xyz.boot.core.mysql.config.AppDubboCoreConfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 19:04
 * @des:
 */
@SpringBootApplication
@Import(AppDubboCoreConfig.class)
@MapperScan(basePackages = "io.github.xyz.boot.fescar.storage.mappers")
@EnableDubbo
public class FescarStorageService {
    public static void main(String[] args) {
        SpringApplication.run(FescarStorageService.class, args);
    }
}
