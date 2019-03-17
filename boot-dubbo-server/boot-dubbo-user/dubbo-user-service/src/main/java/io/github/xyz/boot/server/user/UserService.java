/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import io.github.xyz.boot.core.mysql.config.AppMyBatisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 20:45
 * @des:
 */
@SpringBootApplication
@Import(AppMyBatisConfig.class)
@MapperScan(basePackages = "io.github.xyz.boot.server.user.mappers")
@EnableDubbo
public class UserService {
    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
    }
}
