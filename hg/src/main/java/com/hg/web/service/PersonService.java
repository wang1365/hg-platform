package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.entity.Person;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface PersonService extends IService<Person> {
    boolean exists(Person person);
    List<Person> getPersonListByType(int type);
    List<Person> getPersonListByCompany(String companyName);
}
