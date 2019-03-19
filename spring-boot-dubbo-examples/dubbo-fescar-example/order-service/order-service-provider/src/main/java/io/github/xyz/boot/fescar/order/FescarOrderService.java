/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import io.github.xyz.boot.core.mysql.config.AppDubboCoreConfig;
import io.github.xyz.boot.fescar.order.api.OrderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 20:38
 * @des: 订单服务
 */
@SpringBootApplication
@Import(AppDubboCoreConfig.class)
@MapperScan(basePackages = "io.github.xyz.boot.fescar.order.mappers")
@EnableDubbo
public class FescarOrderService {
    public static void main(String[] args) {
        SpringApplication.run(OrderService.class, args);
    }
}
