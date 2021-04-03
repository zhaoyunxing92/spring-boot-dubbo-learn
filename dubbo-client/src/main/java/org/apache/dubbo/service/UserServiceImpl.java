/**
 * Copyright(C) 2021 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package org.apache.dubbo.service;

import org.apache.dubbo.User;
import org.apache.dubbo.UserProvider;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @author zhaoyunxing
 * @date: 2021-04-03 02:43
 */
public class UserServiceImpl implements UserService {

    @Reference
    private UserProvider userProvider;

    @Override
    public User getUser(String id) {
        return userProvider.GetUser(id);
    }
}
