package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
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

    private Integer status;
    private Integer auditStatus;
    private BigDecimal amount;
    private BigDecimal reduceAmount;
}