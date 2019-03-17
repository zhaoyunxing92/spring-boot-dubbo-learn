package io.github.xyz.boot.server.user.entities;


import io.github.xyz.boot.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AccountEntity extends BaseModel<Long> {
    /**
     * account
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户ｉｄ
     */
    private String userId;

    /**
     * 账户余额
     */
    private Long balance;

}