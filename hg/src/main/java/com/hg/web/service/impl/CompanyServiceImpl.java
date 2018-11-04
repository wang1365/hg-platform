package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.repository.CompanyMapper;
import com.hg.web.entity.Company;
import com.hg.web.service.CompanyService;
import org.springframework.stereotype.Service;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 11:07
 * @description:
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
}
