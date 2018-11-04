package com.hg.web.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 11:06
 * @description: 商品标签
 */
@Data
public class GoodsLabel extends BaseEntity {
    private String barCode;
    private String labelCode;
    private Date productDate;
    private Integer expireDays;
    private Integer status;
    private Date createTime;
}