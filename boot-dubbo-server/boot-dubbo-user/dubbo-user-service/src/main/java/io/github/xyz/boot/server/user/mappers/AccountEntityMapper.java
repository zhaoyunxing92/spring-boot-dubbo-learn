package io.github.xyz.boot.server.user.mappers;


import io.github.xyz.boot.common.mapper.BaseMapper;
import io.github.xyz.boot.server.user.entities.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityMapper extends BaseMapper<AccountEntity, Long> {
}