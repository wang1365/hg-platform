package com.hg.web.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * author: Xiaochuan Wang
 * date: 2018/11/30 14:34
 * description:
 */
@Data
public class Fake extends BaseEntity {
    private BigDecimal totalSaleAmount;
    private Integer totalSaleCount;
    private BigDecimal todaySaleAmount;
    private Integer todaySaleCount;
    private Integer userCount;
    private Integer onlineDeviceCount;
    private Integer offlineDeviceCount;
    private Integer totalWeight;
}