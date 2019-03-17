/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.web.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.server.order.api.OrderService;
import io.github.xyz.boot.server.order.entities.OrderEntity;
import io.github.xyz.boot.web.order.vo.OrderVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 15:13
 * @des:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order 　订单
     * @return　OrderEntity
     */
    @PostMapping
    public Response<OrderEntity> creatOder(@RequestBody @Validated OrderVo order) {
        return orderService.creatOrder(order.getUserId(), order.getCommodityId(), order.getCount());
    }
}
