/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.user.api;

import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.server.user.entities.AccountEntity;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:20
 * @des:　账户
 */
public interface AccountService {
    /**
     * debit balance of user's account
     *
     * @param userId 用户
     * @param money  金额
     */
    Response<String> debit(String userId, Long money);

    /**
     * 获取账户
     *
     * @param userId 　用户id
     * @return 账户
     */
    Response<AccountEntity> getAccountById(String userId);
}
