package com.xiaochuan.web.dto;

import com.xiaochuan.web.entity.QualityReport;
import lombok.Data;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description: 针对某一批次商品的溯源信息
 */
@Data
public class TraceInfoDTO {
    Integer orderId;

    private OrderDTO orderDTO;
    private PlantDTO plantDTO;
    private List<PlantItemDTO> plantItemDTOList;
    /**
     * 质检报告
     */
    private QualityReport qualityReport;
}