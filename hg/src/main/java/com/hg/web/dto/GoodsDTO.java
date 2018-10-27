package com.hg.web.dto;

import com.hg.web.entity.Goods;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/27 21:59
 * @description:
 */
@Data
public class GoodsDTO extends Goods {
    private String brandName;
    private String catName;
}