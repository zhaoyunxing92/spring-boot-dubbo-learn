package io.github.xyz.boot.server.order.entities;


import io.github.xyz.boot.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;
    /**
     * 订单名称
     */
    private String name;

    /**
     * 订单描述
     */
    private String desc;

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