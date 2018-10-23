package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.QualificationDTO;
import com.xiaochuan.web.entity.Qualification;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface QualificationService {
    List<QualificationDTO> getAllQualification();
    int addQualification(Qualification qualification);
    void deleteQualification(int id);
}
