package com.hg.web.entity;

import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 11:06
 * @description: 商品品牌
 */
@Data
public class GoodsBrand extends BaseEntity {
    private String name;
    private String desc;
}