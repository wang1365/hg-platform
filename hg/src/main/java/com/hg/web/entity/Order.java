package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/3 11:07
 * @description: 商品采购订单
 */
@Data
@TableName("`order`")
public class Order {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private Integer goodsId;

    private Date orderTime;

    private Integer quantity;

    private String unit;

    /**
     * 价格，单位：分/kg
     */
    private Integer price;

    /**
     * 采购地点
     */
    private String address;

    /**
     * 被采购人（农户）
     */
    private Integer sellerId;

    /**
     * 采购人或者组织
     */
    private Integer buyerId;

    /**
     * 关联的质检报告ID
     */
    private Integer reportId;

    /**
     * 关联的种植计划
     */
    private Long plantId;
    /**
     * 关联的种植计划中的采摘ID
     */
    private Long pickId;
}