package com.xiaochuan.web.dto;

import com.xiaochuan.utils.DatetimeUtil;
import com.xiaochuan.web.entity.PlantItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description:
 */
@ToString
public class PlantItemDTO extends PlantItem {
    @Getter@Setter
    private String farmerName;
    @Getter@Setter
    private String actionName;
    private String summary;

    public String getSummary() {
        summary = String.format("%d: %s-%s-%s", getId(), farmerName, actionName,
                DatetimeUtil.formatDate(getActionDate()));
        return summary;
    }
}