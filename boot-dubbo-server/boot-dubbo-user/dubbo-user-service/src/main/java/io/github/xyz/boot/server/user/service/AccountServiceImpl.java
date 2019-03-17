/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.core.common.exception.AppServiceException;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.server.user.api.AccountService;
import io.github.xyz.boot.server.user.entities.AccountEntity;
import io.github.xyz.boot.server.user.mappers.AccountEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author zhaoyunxing
 * @date: 2019-03-17 20:01
 * @des:
 */
@Service(interfaceClass = AccountService.class)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountEntityMapper accountEntityMapper;

    /**
     * debit balance of user's account
     *
     * @param userId 用户
     * @param money  金额
     */
    @Override
    public Response<String> debit(String userId, Long money) {
        if (accountEntityMapper.debitAccountById(userId, money) <= 0) {
            throw new AppServiceException("扣款失败");
        }
        return new Response<>(0, "扣款成功", null);
    }

    /**
     * 获取账户
     *
     * @param userId 　用户id
     * @return 账户
     */
    @Override
    public Response<AccountEntity> getAccountById(String userId) {
        AccountEntity account = accountEntityMapper.selectByAccountById(userId);
        if (null == account) {
            throw new AppServiceException("该账户不存在");
        }
        return new Response<>(0, "获取账户成功", account);
    }
}
