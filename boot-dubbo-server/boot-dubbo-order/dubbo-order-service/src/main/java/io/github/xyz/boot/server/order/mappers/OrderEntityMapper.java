package io.github.xyz.boot.server.order.mappers;


import io.github.xyz.boot.common.mapper.BaseMapper;
import io.github.xyz.boot.server.order.entities.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityMapper extends BaseMapper<OrderEntity, Long> {
}