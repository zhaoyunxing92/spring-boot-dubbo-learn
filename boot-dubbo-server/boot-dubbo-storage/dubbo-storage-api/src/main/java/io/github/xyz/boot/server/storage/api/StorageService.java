/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.server.storage.api;

import io.github.xyz.boot.common.result.Response;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:15
 * @des:
 */
public interface StorageService {
    /**
     * deduct storage count
     *
     * @param commodityId 库存ｉｄ
     * @param count       　数量
     * @return　Response
     */
    Response<String> deduct(String commodityId, Integer count);
}
