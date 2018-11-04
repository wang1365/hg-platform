package com.hg.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.repository.PersonMapper;
import com.hg.web.entity.Person;
import com.hg.web.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
@Slf4j
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
    @Override
    public boolean exists(Person person) {
        return this.getOne(new QueryWrapper<>(person)) != null;
    }

    @Override
    public List<Person> getPersonListByType(int type) {
        Person person = new Person();
        person.setType(type);
        return list(new QueryWrapper<>(person));
    }

    @Override
    public List<Person> getPersonListByCompany(String companyName) {
        Person person = new Person();
        person.setCompany(companyName);
        return list(new QueryWrapper<>(person));
    }
}
