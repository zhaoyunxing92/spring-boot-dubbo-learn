/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.order.api;

import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.server.order.entities.OrderEntity;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:05
 * @des:
 */
public interface OrderService {
    /**
     * create order
     *
     * @param userId      用户ｉｄ
     * @param commodityId 　商品ｉｄ
     * @param count       购买数量
     * @return Response
     */
    Response<OrderEntity> creatOrder(String userId, String commodityId, Integer count);
}
