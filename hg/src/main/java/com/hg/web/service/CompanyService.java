package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.entity.Company;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface CompanyService extends IService<Company> {
    List<Company> getAll();
    int add(Company company);
    int update(Company company);
    void delete(int id);
}
