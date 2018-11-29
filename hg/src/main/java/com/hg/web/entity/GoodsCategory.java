package com.hg.web.entity;

import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:37
 * @description: 商品分类
 */
@Data
public class GoodsCategory extends BaseEntity {
    private String name;
    private String comment;
}