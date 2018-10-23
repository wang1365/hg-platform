package com.xiaochuan.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description: 农户种植计划
 */
@Data
public class Plant {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 农作物ID
     */
    private Integer goodsId;
    /**
     * 农户ID
     */
    private Integer farmerId;

    private Integer year;
    /**
     * 种植计划开始时间
     */
    private Date startDate;
    /**
     * 种植地址
     */
    private String address;
    /**
     * 记录创建时间
     */
    private Date createTime;
}