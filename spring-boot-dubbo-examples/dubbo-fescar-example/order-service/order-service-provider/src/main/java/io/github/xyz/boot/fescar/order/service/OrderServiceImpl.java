/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.order.service;

import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.fescar.order.api.OrderService;
import io.github.xyz.boot.fescar.order.entities.OrderEntity;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 15:00
 * @des:
 */
public class OrderServiceImpl implements OrderService {
    /**
     * create order
     *
     * @param userId      用户ｉｄ
     * @param commodityId 　商品ｉｄ
     * @param count       购买数量
     * @return Response
     */
    @Override
    public Response<OrderEntity> creatOrder(String userId, String commodityId, Integer count) {
        return null;
    }
}
