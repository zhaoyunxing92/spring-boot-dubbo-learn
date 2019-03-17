/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoyunxing
 * @date: 2019-03-17 19:39
 * @des:
 */
@Data
public class BaseModel<ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = 720013901235423189L;

    private ID id;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
