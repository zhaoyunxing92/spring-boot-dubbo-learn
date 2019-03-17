/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.web.order.service;

import io.github.xyz.boot.common.result.Response;
import io.github.xyz.boot.web.order.vo.OrderVo;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 17:00
 * @des:
 */
public interface BusinessService {
    /**
     * 购买
     *
     * @param order 订单
     * @return
     */
    Response purchase(OrderVo order);
}
