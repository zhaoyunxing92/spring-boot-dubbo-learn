package io.github.xyz.boot.server.storage.mappers;


import io.github.xyz.boot.core.common.mapper.BaseMapper;
import io.github.xyz.boot.server.storage.entities.StorageEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageEntityMapper extends BaseMapper<StorageEntity, Long> {
}