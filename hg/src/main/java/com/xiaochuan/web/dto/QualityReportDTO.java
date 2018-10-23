package com.xiaochuan.web.dto;

import com.xiaochuan.web.entity.QualityReport;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description:
 */
@Data
public class QualityReportDTO extends QualityReport {
    private String goodsName;
}