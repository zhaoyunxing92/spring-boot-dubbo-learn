/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.web.order.controller;

import io.github.xyz.boot.common.result.Response;
import io.github.xyz.boot.web.order.service.BusinessService;
import io.github.xyz.boot.web.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 15:13
 * @des:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final BusinessService businessService;

    @Autowired
    public OrderController(BusinessService businessService) {this.businessService = businessService;}

    @PostMapping
    public Response<String> creatOder(@RequestBody @Validated OrderVo order) {
        return businessService.purchase(order);
    }
}
