package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.QualityReportDTO;
import com.xiaochuan.web.entity.QualityReport;


import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface QualityReportService {
    int insert(QualityReport pojo);

    List<QualityReportDTO> selectAll();

    List<QualityReportDTO> select(QualityReport pojo);

    void delete(int id);
}
