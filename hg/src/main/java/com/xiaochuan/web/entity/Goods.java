package com.xiaochuan.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
@EqualsAndHashCode(of="id")
public class Goods {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private String name;
    private String imageUrl;
}