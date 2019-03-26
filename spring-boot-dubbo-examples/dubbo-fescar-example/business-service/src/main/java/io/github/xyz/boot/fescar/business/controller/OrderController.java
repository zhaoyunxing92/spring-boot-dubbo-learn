/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.business.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.fescar.business.controller.vo.OrderVo;
import io.github.xyz.boot.fescar.order.api.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhaoyunxing
 * @date: 2019-03-19 14:52
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
    // @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-fescar-example")
    public Response creatOder(@RequestBody @Validated OrderVo order) {
        return orderService.creatOrder(order.getUserId(), order.getCommodityId(), order.getCount());
    }
}
