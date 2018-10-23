package com.xiaochuan.web.dto;

import com.xiaochuan.web.entity.Plant;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description:
 */
@Data
public class PlantDTO extends Plant{
    private String goodsName;
    private String farmerName;
    private String summary;

    public String getSummary() {
        summary = String.format("%d: %s-%s-%d", getId(), farmerName, goodsName, getYear());
        return summary;
    }
}