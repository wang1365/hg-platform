package com.xiaochuan.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaochuan.web.repository.GoodsMapper;
import com.xiaochuan.web.dto.QualityReportDTO;
import com.xiaochuan.web.entity.Goods;
import com.xiaochuan.web.entity.QualityReport;
import com.xiaochuan.web.service.QualityReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.xiaochuan.web.repository.QualityReportMapper;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
public class QualityReportServiceImpl implements QualityReportService {

    @Autowired
    private QualityReportMapper qualityReportDao;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int insert(QualityReport pojo){
        return qualityReportDao.insert(pojo);
    }


    @Override
    public List<QualityReportDTO> selectAll() {

        List<QualityReport> reports =  qualityReportDao.selectList(null);
        return wrapQualityReportDTO(reports);
    }

    @Override
    public List<QualityReportDTO> select(QualityReport pojo){
        QueryWrapper wrapper = new QueryWrapper(pojo);
        List<QualityReport> reports = qualityReportDao.selectList(wrapper);
        return wrapQualityReportDTO(reports);    }

    private List<QualityReportDTO> wrapQualityReportDTO(List<QualityReport> reports) {
        return reports.stream().map(report -> {
            QualityReportDTO dto = new QualityReportDTO();
            BeanUtils.copyProperties(report, dto);
            Goods goods = goodsMapper.selectById(report.getGoodsId());
            dto.setGoodsName(goods.getName());
            return dto;
        }).collect(Collectors.toList());
    }
    @Override
    public void delete(int id) {
        qualityReportDao.deleteById(id);
    }
}
