package com.xiaochuan.web.service;

import com.xiaochuan.web.entity.Person;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface PersonService {
    Person getPersonById(int id);
    boolean exists(Person person);
    int addPerson(Person person);
    int updatePerson(Person person);
    List<Person> getAllPersons();
    List<Person> getPersonListByType(int type);
    void deletePerson(int id);
}
