package com.hg.promotion.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.promotion.consts.PromotionType;
import com.hg.promotion.dto.PromotionDTO;
import com.hg.promotion.entity.Promotion;
import com.hg.promotion.entity.rule.Discount;
import com.hg.promotion.entity.rule.FirstReduction;
import com.hg.promotion.entity.rule.FullReduction;
import com.hg.promotion.entity.rule.RandomReduction;
import com.hg.promotion.repository.*;
import com.hg.promotion.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:16
 * @description:
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements PromotionService {
    @Resource
    private FirstReductionService firstReductionService;

    @Resource
    private FullReductionService fullReductionService;

    @Resource
    private RandomReductionService randomReductionService;

    @Resource
    private DiscountService discountService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addPromotionDetail(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        this.save(promotion);

        savePromotionItem(promotionDTO);
        return promotion.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        this.updateById(promotion);

        FirstReduction reduction = new FirstReduction();
        reduction.setPromotionId(promotion.getId());
        FullReduction fullReduction = new FullReduction();
        fullReduction.setPromotionId(promotion.getId());
        RandomReduction randomReduction = new RandomReduction();
        randomReduction.setPromotionId(promotion.getId());
        Discount discount = new Discount();
        discount.setPromotionId(promotion.getId());

        firstReductionService.remove(new QueryWrapper<>(reduction));
        fullReductionService.remove(new QueryWrapper<>(fullReduction));
        randomReductionService.remove(new QueryWrapper<>(randomReduction));
        discountService.remove(new QueryWrapper<>(discount));

        savePromotionItem(promotionDTO);
        return true;
    }

    private void savePromotionItem(PromotionDTO promotionDTO) {
        int ruleId = promotionDTO.getRuleId();
        if (ruleId == PromotionType.FIRST_REDUCTION.getCode()) {
            firstReductionService.save(promotionDTO.getFirstReduction());
        } else if (ruleId == PromotionType.FULL_REDUCTION.getCode()) {
            fullReductionService.saveBatch(promotionDTO.getFullReductions());
        } else if (ruleId == PromotionType.RANDOM_REDUCTION.getCode()) {
            randomReductionService.save(promotionDTO.getRandomReduction());
        } else if (ruleId == PromotionType.DISCOUNT.getCode()) {
            discountService.save(promotionDTO.getDiscount());
        }
    }
}