package com.hg.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.promotion.entity.Promotion;
import com.hg.promotion.repository.PromotionMapper;
import com.hg.promotion.service.PromotionService;
import org.springframework.stereotype.Service;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:16
 * @description:
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements PromotionService {
}