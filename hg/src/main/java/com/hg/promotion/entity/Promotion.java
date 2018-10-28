package com.hg.promotion.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:01
 * @description: 促销
 */
@Data
public class Promotion {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private Date startTime;
    private Date endTime;
    private Integer limitTimes;
    /**
     * 1:首单立减 2:优惠折扣 3:商品满减 4:随机立减
     */
    private Integer ruleType;
    private Integer ruleId;
    private Boolean includeAllCat;
    private Boolean includeAllBrand;
    private Boolean includeAllHg;
    private Boolean audited;
    private String desc;
    private Date createTime;
}