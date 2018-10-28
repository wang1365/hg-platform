package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
@EqualsAndHashCode(of="id")
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer catId;
    private Integer brandId;
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
    private String desc;
    private Boolean valid;
}