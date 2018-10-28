package com.hg.promotion.dto;

import com.hg.promotion.entity.Promotion;
import com.hg.promotion.entity.rule.PromotionRule;
import lombok.Data;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:19
 * @description:
 */
@Data
public class PromotionDTO  extends Promotion {
    private PromotionRule firstReduction;
    private List<PromotionRule> fullReductions;
    private PromotionRule randomReduction;
    private PromotionRule discount;
}