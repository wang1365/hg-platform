package com.hg.promotion.entity.rule;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:21
 * @description:
 */
@Data
public class PromotionRule {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer promotionId;
}