package com.hg.promotion.entity.rule;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:09
 * @description:
 */
@Data
@TableName("promotion_rule_discount")
public class Discount extends PromotionRule {
    private BigDecimal rate;
}