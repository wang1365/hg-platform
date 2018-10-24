package com.xiaochuan.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
@EqualsAndHashCode(of="id")
public class Goods {
    private Integer id;
    private String name;
    private Integer catId;
    private Integer brandId;
    /**
     * 条形码
     */
    private String qrCode;
    /**
     * 采购价格 单位分
     */
    private Integer purchasePrice;
    /**
     * 销售价格，单位分
     */
    private Integer salePrice;
    /**
     * 净含量，单位g
     */
    private Integer weight;
    /**
     * 保质期天数
     */
    private Integer expireDays;
    private String desc;
    private boolean isValid;
}