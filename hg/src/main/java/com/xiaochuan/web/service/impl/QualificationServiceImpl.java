package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.CompanyMapper;
import com.xiaochuan.web.repository.QualificationMapper;
import com.xiaochuan.web.dto.QualificationDTO;
import com.xiaochuan.web.entity.Company;
import com.xiaochuan.web.entity.Qualification;
import com.xiaochuan.web.service.QualificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
public class QualificationServiceImpl implements QualificationService {
    @Autowired
    private QualificationMapper qualificationMapper;
    @Autowired
    private CompanyMapper companyMapper;

    public QualificationServiceImpl(QualificationMapper qualificationMapper) {
        this.qualificationMapper = qualificationMapper;
    }

    @Override
    public List<QualificationDTO> getAllQualification() {
        List<Qualification> qualifications = qualificationMapper.selectList(null);

        return qualifications.stream().map(qualification -> {
            QualificationDTO dto = new QualificationDTO();
            BeanUtils.copyProperties(qualification, dto);
            Company company = companyMapper.selectById(qualification.getCompanyId());
            dto.setCompanyName(company.getName());
            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public int addQualification(Qualification qualification) {
        return qualificationMapper.insert(qualification);
    }

    @Override
    public void deleteQualification(int id) {
        qualificationMapper.deleteById(id);
    }
}