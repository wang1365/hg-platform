package com.hg.web.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * author: Xiaochuan Wang
 * date: 2018/11/30 14:34
 * description:
 */
@Data
public class FakeDailyReport extends BaseEntity {
    private Date day;
    private BigDecimal saleAmount;
    private Integer saleCount;
    private Integer userCount;
    private Integer saleWeight;
}