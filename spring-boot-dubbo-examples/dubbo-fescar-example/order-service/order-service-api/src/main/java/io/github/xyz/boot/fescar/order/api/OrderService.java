/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.order.api;

import io.github.xyz.boot.core.common.result.Response;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 14:15
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
    Response creatOrder(String userId, String commodityId, Integer count);
}
