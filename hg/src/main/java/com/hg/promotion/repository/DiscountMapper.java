package com.hg.promotion.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hg.promotion.entity.rule.Discount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:12
 * @description:
 */
@Mapper
public interface DiscountMapper extends BaseMapper<Discount> {
}
