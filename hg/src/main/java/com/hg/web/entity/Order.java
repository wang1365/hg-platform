package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/30 11:07
 * @description: 用户订单
 */
@Data
@TableName("`order`")
public class Order extends BaseEntity {
    private Integer status;
    private Integer auditStatus;
    private BigDecimal amount;
    private BigDecimal reduceAmount;
    private Integer areaId;
    private String userName;
    private Integer goodsId;
}