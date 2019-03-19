/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.storage.api;

import io.github.xyz.boot.fescar.storage.entities.StorageEntity;

import javax.xml.ws.Response;


/**
 * @author zhaoyunxing
 * @date: 2019-03-19 15:27
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

    /**
     * 根据商品id获取商品
     *
     * @param commodityId 商品id
     * @return
     */
    Response<StorageEntity> getStorageById(String commodityId);
}
