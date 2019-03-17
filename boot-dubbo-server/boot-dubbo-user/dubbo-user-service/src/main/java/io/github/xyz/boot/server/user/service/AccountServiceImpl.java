/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.common.result.Response;
import io.github.xyz.boot.server.user.api.AccountService;


/**
 * @author zhaoyunxing
 * @date: 2019-03-17 20:01
 * @des:
 */
@Service(interfaceClass = AccountService.class)
public class AccountServiceImpl implements AccountService {
    /**
     * debit balance of user's account
     *
     * @param userId 用户
     * @param money  金额
     */
    @Override
    public Response<String> debit(String userId, Long money) {
        return null;
    }
}
