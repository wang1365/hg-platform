package com.hg.web.dto;

import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsLabel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 00:21
 * @description:
 */
@Data
public class GoodsLabelDTO extends GoodsLabel {
    private String goodsName;
    private String unit;
    private BigDecimal weight;
    private String catName;
    private String brandName;
}