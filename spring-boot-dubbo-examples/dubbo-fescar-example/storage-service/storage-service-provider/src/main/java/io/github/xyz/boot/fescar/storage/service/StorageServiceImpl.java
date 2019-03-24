/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.storage.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.xyz.boot.core.common.exception.AppServiceException;
import io.github.xyz.boot.core.common.result.Response;
import io.github.xyz.boot.fescar.storage.api.StorageService;
import io.github.xyz.boot.fescar.storage.entities.StorageEntity;
import io.github.xyz.boot.fescar.storage.mappers.StorageEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 16:57
 * @des:
 */
@Service(interfaceClass = StorageService.class)
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageEntityMapper storageEntityMapper;

    /**
     * deduct storage count
     *
     * @param commodityId 库存ｉｄ
     * @param count       　数量
     * @return　Response
     */
    @Override
    public Response<String> deduct(String commodityId, Integer count) {

        if (storageEntityMapper.deductStorageById(commodityId, count) <= 0) {
            //            throw new AppServiceException("库减失败");
            return new Response<>(500, "库减失败");
        }

        return new Response<>(0, "库减成功", true);
    }

    /**
     * 根据商品id获取商品
     *
     * @param commodityId 　商品id
     * @return StorageEntity
     */
    @Override
    public Response<StorageEntity> getStorageById(String commodityId) {
        StorageEntity storage = storageEntityMapper.selectStorageByCode(commodityId);
        if (null == storage) {
            throw new AppServiceException("商品不存在");
        }
        return new Response<>(0, "获取商品成功", storage);
    }
}