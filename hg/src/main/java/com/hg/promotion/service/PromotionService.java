package com.hg.promotion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.promotion.dto.PromotionDTO;
import com.hg.promotion.entity.Promotion;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:15
 * @description:
 */
public interface PromotionService extends IService<Promotion> {
    int addPromotionDetail(PromotionDTO promotionDTO);
    boolean updateById(PromotionDTO promotionDTO);
    void removeByIdAndRuleType(int id, int ruleType);
}
