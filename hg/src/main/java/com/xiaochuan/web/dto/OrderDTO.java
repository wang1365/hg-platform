package com.xiaochuan.web.dto;

import com.xiaochuan.utils.DatetimeUtil;
import com.xiaochuan.web.entity.Order;
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

    /**
     * 关联的生产计划
     */
    private PlantDTO plantDTO;
    /**
     * 采摘信息（每个订单必须关联一个采摘信息）
     */
    private PlantItemDTO pickDTO;

    private String summary;

    public String getSummary() {
        return String.format("%d: %s %s收购%s %s %d %s", getId(), DatetimeUtil.formatDate(getOrderTime()),
                buyerName, sellerName, goodsName, getQuantity(), getUnit());
    }
}