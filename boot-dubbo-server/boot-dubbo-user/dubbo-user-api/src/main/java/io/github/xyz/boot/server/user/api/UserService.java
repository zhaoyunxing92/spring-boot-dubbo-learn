/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.user.api;

import io.github.xyz.boot.common.result.Response;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:20
 * @des:　账户
 */
public interface UserService {
    /**
     * debit balance of user's account
     *
     * @param userId 用户
     * @param money  金额
     */
    Response<String> debit(String userId, Long money);
}
