package io.github.xyz.boot.fescar.account.entities;


import io.github.xyz.boot.core.common.model.BaseModel;
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
     * 账户余额（单位：分）
     */
    private Long balance;

}