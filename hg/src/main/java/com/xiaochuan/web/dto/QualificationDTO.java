package com.xiaochuan.web.dto;

import com.xiaochuan.web.entity.Qualification;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:48
 * @description:
 */
@Data
public class QualificationDTO  extends Qualification {
    private String companyName;
}