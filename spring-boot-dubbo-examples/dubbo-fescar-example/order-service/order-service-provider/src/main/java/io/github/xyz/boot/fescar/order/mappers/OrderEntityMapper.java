/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.order.mappers;

import io.github.xyz.boot.core.common.mapper.BaseMapper;
import io.github.xyz.boot.fescar.order.entities.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 15:06
 * @des:
 */
@Repository
public interface OrderEntityMapper extends BaseMapper<OrderEntity, Long> {
}
