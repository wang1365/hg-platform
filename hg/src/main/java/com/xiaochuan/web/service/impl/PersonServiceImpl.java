package com.xiaochuan.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaochuan.web.repository.PersonMapper;
import com.xiaochuan.web.entity.Person;
import com.xiaochuan.web.service.PersonService;
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
@CacheConfig(cacheNames = "person")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person getPersonById(int id) {
        if (id <= 0) {
            return null;
        }

        return personMapper.selectById(id);
    }

    @Override
    public boolean exists(Person person) {
        return personMapper.selectOne(new QueryWrapper<>(person)) != null;
    }

    @Override
    @CacheEvict(key = "#person.type")
    public int addPerson(Person person) {
        return personMapper.insert(person);
    }

    @Override
    @CacheEvict(key = "#person.type")
    public int updatePerson(Person person) {
        return personMapper.updateById(person);
    }

    @Override
    public List<Person> getAllPersons() {
        log.info("read data from db");
        return personMapper.selectList(null);
    }

    @Override
    @Cacheable(key="#type")
    public List<Person> getPersonListByType(int type) {
        Person person = new Person();
        person.setType(type);
        return personMapper.selectList(new QueryWrapper<>(person));
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deletePerson(int id) {
        personMapper.deleteById(id);
    }
}
