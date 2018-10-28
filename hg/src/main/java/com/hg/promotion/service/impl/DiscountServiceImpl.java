package com.hg.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.promotion.entity.rule.Discount;
import com.hg.promotion.repository.DiscountMapper;
import com.hg.promotion.service.DiscountService;
import org.springframework.stereotype.Service;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:16
 * @description:
 */
@Service
public class DiscountServiceImpl extends ServiceImpl<DiscountMapper, Discount> implements DiscountService {

}