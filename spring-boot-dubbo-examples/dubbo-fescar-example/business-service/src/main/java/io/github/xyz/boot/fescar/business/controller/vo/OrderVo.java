/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.fescar.business.controller.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 16:53
 * @des:
 */
@Data
public class OrderVo {
    /**
     * 用户ｉｄ
     */
    @NotBlank(message = "请输入用户ｉｄ")
    private String userId;
    /**
     * 商品ｉｄ
     */
    @NotBlank(message = "请选择商品ｉｄ")
    private String commodityId;
    /**
     * 购买数量
     */
    @Min(value = 1, message = "购买数量最小是{value}")
    private Integer count;
}
