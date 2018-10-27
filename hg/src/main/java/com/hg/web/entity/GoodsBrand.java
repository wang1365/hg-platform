package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 11:06
 * @description: 商品品牌
 */
@Data
public class GoodsBrand {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String desc;
}