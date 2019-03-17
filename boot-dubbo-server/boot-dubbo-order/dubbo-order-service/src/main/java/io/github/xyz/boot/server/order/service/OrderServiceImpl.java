/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.core.common.exception.AppServiceException;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.server.order.api.OrderService;
import io.github.xyz.boot.server.order.entities.OrderEntity;
import io.github.xyz.boot.server.order.mappers.OrderEntityMapper;
import io.github.xyz.boot.server.storage.api.StorageService;
import io.github.xyz.boot.server.storage.entities.StorageEntity;
import io.github.xyz.boot.server.user.api.AccountService;
import io.github.xyz.boot.server.user.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:39
 * @des:
 */
@Service(interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Reference
    private StorageService storageService;
    @Reference
    private AccountService accountService;

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
        //　总金额
        Long sumMoney = getSumMoney(commodityId, count);
        // 检查账户余额
        checkAccountBalances(userId, sumMoney);
        // 减库存
        storageService.deduct(commodityId, count);
        // 扣账户钱
        accountService.debit(userId, sumMoney);

        return new Response<>(0, "下单成功", creatOrder(userId, commodityId, count, sumMoney));
    }

    /**
     * 检查账户余额
     *
     * @param userId   　用户ｉｄ
     * @param sumMoney 　订单总金额
     */
    private void checkAccountBalances(String userId, Long sumMoney) {
        Response<AccountEntity> accountres = accountService.getAccountById(userId);
        AccountEntity account = accountres.getData();
        
        if (account.getBalance() < sumMoney) {
            throw new AppServiceException("用户金额不足");
        }
    }

    /**
     * 总金额
     *
     * @param commodityId 　商品ｉｄ
     * @param count       个数
     * @return
     */
    private Long getSumMoney(String commodityId, Integer count) {
        Response<StorageEntity> storageres = storageService.getStorageById(commodityId);
        StorageEntity storage = storageres.getData();
        if (count > storage.getResidue()) {
            throw new AppServiceException("库存不足");
        }
        return (storage.getMoney() * count);
    }

    /**
     * 创建订单
     *
     * @param userId      　用户id
     * @param commodityId 商品ｉｄ
     * @param count       个数
     * @param sumMoney    　总金额
     * @return　OrderEntity
     */
    private OrderEntity creatOrder(String userId, String commodityId, Integer count, Long sumMoney) {
        OrderEntity order = new OrderEntity();
        order.setCommodityId(commodityId);
        order.setCount(count);
        order.setUserId(userId);
        order.setMoney(sumMoney);

        if (orderEntityMapper.insertSelective(order) <= 0) {
            throw new AppServiceException("下单失败");
        }
        return order;
    }
}
