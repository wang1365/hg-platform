package com.hg.promotion.dto;

import com.hg.promotion.entity.Promotion;
import com.hg.promotion.entity.rule.*;
import lombok.Data;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:19
 * @description:
 */
@Data
public class PromotionDTO  extends Promotion {
    private FirstReduction firstReduction;
    private List<FullReduction> fullReductions;
    private RandomReduction randomReduction;
    private Discount discount;
}