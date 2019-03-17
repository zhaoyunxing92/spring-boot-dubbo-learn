/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.common.result.Response;
import io.github.xyz.boot.server.order.api.OrderService;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:39
 * @des:
 */
@Service(interfaceClass = OrderService.class)
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
    public Response<String> creat(String userId, String commodityId, Integer count) {
        return null;
    }
}
