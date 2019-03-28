package io.github.xyz.boot.fescar.storage.mappers;


import io.github.xyz.boot.core.common.mapper.BaseMapper;
import io.github.xyz.boot.fescar.storage.entities.StorageEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageEntityMapper extends BaseMapper<StorageEntity, Long> {
    /**
     * 根据商品码获取商品
     *
     * @param code
     * @return
     */
    StorageEntity selectStorageByCode(@Param("code") String code);

    /**
     * 扣除库存
     *
     * @param commodityId 　商品id
     * @param count       商品个数
     * @return　影响的行数
     */
    int deductStorageById(@Param("commodityId") String commodityId, @Param("count") Integer count);
}