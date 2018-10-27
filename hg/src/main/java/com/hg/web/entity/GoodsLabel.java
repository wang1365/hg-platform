package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 11:06
 * @description: 商品标签
 */
@Data
public class GoodsLabel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String barCode;
    private String labelCode;
    private Date productDate;
    private Integer expireDays;
    private Integer status;
    private Date createTime;
}