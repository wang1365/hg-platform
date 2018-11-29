package com.hg.web.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
public class Goods extends BaseEntity {
    private String name;
    private Long catId;
    private Long brandId;
    /**
     * 条形码
     */
    private String barCode;
    /**
     * 采购价格 单位分
     */
    private BigDecimal purchasePrice;
    /**
     * 销售价格，单位分
     */
    private BigDecimal salePrice;
    /**
     * 单位
     */
    private String unit;
    /**
     * 净含量，单位g
     */
    private BigDecimal weight;
    /**
     * 保质期天数
     */
    private Integer expireDays;
    private String comment;
    private Boolean valid;
}