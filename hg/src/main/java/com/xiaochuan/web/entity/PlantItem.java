package com.xiaochuan.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
public class PlantItem {
    @TableId(value = "id", type= IdType.AUTO)
    private Long id;
    private Long plantId;
    private Integer actionType;
    private Integer actionFarmerId;
    private Date actionDate;
    private String actionContent;
    private Date createTime;
}