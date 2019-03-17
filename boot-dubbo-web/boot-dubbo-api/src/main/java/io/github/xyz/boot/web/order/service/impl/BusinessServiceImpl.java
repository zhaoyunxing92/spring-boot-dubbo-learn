/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.web.order.service.impl;


import io.github.xyz.boot.common.result.Response;
import io.github.xyz.boot.web.order.service.BusinessService;
import io.github.xyz.boot.web.order.vo.OrderVo;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 17:02
 * @des:
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    /**
     * 购买
     *
     * @param order 订单
     * @return
     */
    @Override
    public Response purchase(OrderVo order) {
        return null;
    }
}
