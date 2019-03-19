package io.github.xyz.boot.fescar.order.entities;


import io.github.xyz.boot.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品code
     */
    private String commodityId;

    /**
     * 用户ｉｄ
     */
    private String userId;

    /**
     * 订单金额
     */
    private Long money;

    /**
     * 商品数量
     */
    private Integer count;

}