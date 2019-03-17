/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.storage.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.server.storage.api.StorageService;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:45
 * @des:
 */
@Service(interfaceClass = StorageService.class)
public class StorageServiceImpl implements StorageService {

    /**
     * deduct storage count
     *
     * @param commodityId 库存ｉｄ
     * @param count       　数量
     * @return　Response
     */
    @Override
    public Response<String> deduct(String commodityId, Integer count) {
        return null;
    }
}
