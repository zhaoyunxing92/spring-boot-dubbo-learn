/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.common.mapper;

import io.github.xyz.boot.common.model.BaseModel;

import java.io.Serializable;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 19:38
 * @des:
 */
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable> {

    int deleteByPrimaryKey(ID id);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);
}
