package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:37
 * @description: 商品分类
 */
@Data
public class GoodsCategory {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String desc;
}