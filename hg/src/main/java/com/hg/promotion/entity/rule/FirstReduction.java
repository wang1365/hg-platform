package com.hg.promotion.entity.rule;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:05
 * @description:
 */
@Data
@TableName("promotion_rule_first_reduction")
public class FirstReduction extends PromotionRule {
    private BigDecimal reduceValue;
}