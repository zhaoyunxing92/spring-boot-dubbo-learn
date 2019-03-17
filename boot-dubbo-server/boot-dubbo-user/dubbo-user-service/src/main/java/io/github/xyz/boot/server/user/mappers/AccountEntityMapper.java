package io.github.xyz.boot.server.user.mappers;


import io.github.xyz.boot.core.common.mapper.BaseMapper;
import io.github.xyz.boot.server.user.entities.AccountEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityMapper extends BaseMapper<AccountEntity, Long> {
    /**
     * 获取账户
     *
     * @param userId 　用户id
     * @return 账户
     */
    AccountEntity selectByAccountById(@Param("userId") String userId);

    /**
     * 扣钱
     *
     * @param userId 　用户id
     * @param money  金额
     */
    int debitAccountById(@Param("userId") String userId, @Param("money") Long money);
}