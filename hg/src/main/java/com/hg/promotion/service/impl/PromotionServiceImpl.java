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
import java.util.List;

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

        promotionDTO.setId(promotion.getId());
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

    @Override
    public void removeByIdAndRuleType(int id, int ruleType) {
        deletePromotionItems(id, ruleType);
        this.removeById(id);
    }

    private void deletePromotionItems(int id, int ruleType) {
        if (ruleType == PromotionType.FIRST_REDUCTION.getCode()) {
            FirstReduction reduction = new FirstReduction();
            reduction.setPromotionId(id);
            firstReductionService.remove(new QueryWrapper<>(reduction));
        } else if (ruleType == PromotionType.FULL_REDUCTION.getCode()) {
            FullReduction reduction = new FullReduction();
            reduction.setPromotionId(id);
            fullReductionService.remove(new QueryWrapper<>(reduction));
        } else if (ruleType == PromotionType.RANDOM_REDUCTION.getCode()) {
            RandomReduction reduction = new RandomReduction();
            reduction.setPromotionId(id);
            randomReductionService.remove(new QueryWrapper<>(reduction));
        } else if (ruleType == PromotionType.DISCOUNT.getCode()) {
            Discount reduction = new Discount();
            reduction.setPromotionId(id);
            discountService.remove(new QueryWrapper<>(reduction));
        }
    }

    private void savePromotionItem(PromotionDTO promotionDTO) {
        int ruleId = promotionDTO.getRuleType();
        if (ruleId == PromotionType.FIRST_REDUCTION.getCode()) {
            FirstReduction reduction = promotionDTO.getFirstReduction();
            reduction.setPromotionId(promotionDTO.getId());

            firstReductionService.save(reduction);
        } else if (ruleId == PromotionType.FULL_REDUCTION.getCode()) {
            List<FullReduction> reductions = promotionDTO.getFullReductions();
            reductions.forEach(r->{
                r.setPromotionId(promotionDTO.getId());
                fullReductionService.save(r);
            });
        } else if (ruleId == PromotionType.RANDOM_REDUCTION.getCode()) {
            RandomReduction reduction = promotionDTO.getRandomReduction();
            reduction.setPromotionId(promotionDTO.getId());

            randomReductionService.save(reduction);
        } else if (ruleId == PromotionType.DISCOUNT.getCode()) {
            Discount reduction = promotionDTO.getDiscount();
            reduction.setPromotionId(promotionDTO.getId());
            discountService.save(reduction);
        }
    }
}