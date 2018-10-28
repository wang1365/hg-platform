package com.hg.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.promotion.dto.PromotionDTO;
import com.hg.promotion.entity.Promotion;
import com.hg.promotion.repository.PromotionMapper;
import com.hg.promotion.service.PromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:16
 * @description:
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements PromotionService {
    @Override
    public int addPromotionDetail(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        this.save(promotion);
        return promotion.getId();
    }

    @Override
    public boolean updateById(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        this.updateById(promotion);
        return true;
    }
}