package com.hg.promotion.entity.rule;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:06
 * @description:
 */
@Data
@TableName("promotion_rule_full_reduction")
public class FullReduction extends PromotionRule {
    private BigDecimal fullValue;
    private BigDecimal reduceValue;
}