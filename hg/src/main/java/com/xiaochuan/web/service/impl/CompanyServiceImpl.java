package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.CompanyMapper;
import com.xiaochuan.web.entity.Company;
import com.xiaochuan.web.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 11:07
 * @description:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public List<Company> getAll() {
        return companyMapper.selectList(null);
    }

    @Override
    public int add(Company company) {
        return companyMapper.insert(company);
    }

    @Override
    public int update(Company company) {
        return companyMapper.updateById(company);
    }

    @Override
    public void delete(int id) {
        companyMapper.deleteById(id);
    }
}
