package com.hg.web.dto;

import com.hg.web.entity.Order;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description:
 */

@Data
public class OrderDTO extends Order {
    private String reportTitle;
    private String goodsName;
    private String sellerName;
    private String buyerName;

    private String summary;
}