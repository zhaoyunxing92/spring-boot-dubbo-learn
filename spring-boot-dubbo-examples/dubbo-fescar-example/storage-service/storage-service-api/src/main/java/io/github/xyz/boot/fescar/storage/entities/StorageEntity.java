package io.github.xyz.boot.fescar.storage.entities;

import io.github.xyz.boot.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StorageEntity extends BaseModel<Long> {
    /**
     * storage
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品code
     */
    private String commodityId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String desc;

    /**
     * 商品单价（单位：分）
     */
    private Long money;

    /**
     * 剩余库存
     */
    private Integer residue;
}