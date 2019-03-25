/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.core.common.exception.AppServiceException;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.fescar.account.api.AccountService;
import io.github.xyz.boot.fescar.account.entities.AccountEntity;
import io.github.xyz.boot.fescar.order.api.OrderService;
import io.github.xyz.boot.fescar.order.entities.OrderEntity;
import io.github.xyz.boot.fescar.order.mappers.OrderEntityMapper;
import io.github.xyz.boot.fescar.storage.api.StorageService;
import io.github.xyz.boot.fescar.storage.entities.StorageEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 15:00
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
    public Response creatOrder(String userId, String commodityId, Integer count) {
        //　总金额
        //Long sumMoney = getSumMoney(commodityId, count);
        Response<Long> sumMoney = getSumMoney(commodityId, count);
        if (!sumMoney.getSucceed()) return sumMoney;

        Long sum = sumMoney.getData();
        // 检查账户余额,方便出错不检查金额
        // Response<String> check = checkAccountBalances(userId, sum);
        //  if (!check.getSucceed()) return check;
        // 减库存
        Response<String> deduct = storageService.deduct(commodityId, count);
        if (!deduct.getSucceed()) return deduct;
        // 扣账户钱
        Response<String> debit = accountService.debit(userId, sum);
        if (!debit.getSucceed()) return debit;

        return creatOrder(userId, commodityId, count, sum);
    }

    /**
     * 检查账户余额
     *
     * @param userId   　用户ｉｄ
     * @param sumMoney 　订单总金额
     */
    private Response<String> checkAccountBalances(String userId, Long sumMoney) {
        Response<AccountEntity> accountres = accountService.getAccountById(userId);
        AccountEntity account = accountres.getData();

        if (account.getBalance() < sumMoney) {
            //            throw new AppServiceException("用户金额不足");
            return new Response<>(500, "账户金额不足");
        }
        return new Response<>(0, "金额充足", true);
    }

    /**
     * 总金额
     *
     * @param commodityId 　商品ｉｄ
     * @param count       个数
     * @return
     */
    private Response<Long> getSumMoney(String commodityId, Integer count) {
        Response<StorageEntity> storageres = storageService.getStorageById(commodityId);
        StorageEntity storage = storageres.getData();
        if (count > storage.getResidue()) {
            //            throw new AppServiceException("库存不足");
            return new Response<>(500, "库存不足");
        }
        return new Response<>(0, "获取总金额成功", true, storage.getMoney() * count);
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
    private Response creatOrder(String userId, String commodityId, Integer count, Long sumMoney) {
        OrderEntity order = new OrderEntity();
        order.setCommodityId(commodityId);
        order.setCount(count);
        order.setUserId(userId);
        order.setMoney(sumMoney);

        if (orderEntityMapper.insertSelective(order) <= 0) {
            //  throw new AppServiceException("下单失败");
            return new Response<String>(500, "下单失败");
        }
        return new Response<>(0, "下单成功", true, order);
    }
}
