package com.xiaochuan.web.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description: 农户种植计划
 */
@Getter
public class PlantRequest {
    private Long id;
    /**
     * 农作物ID
     */
    private Integer goodsId;
    /**
     * 农户ID
     */
    private Integer farmerId;

    private String year;
    /**
     * 种植计划开始时间
     */
    private Date startDate;
    /**
     * 种植地址
     */
    private String address;
}