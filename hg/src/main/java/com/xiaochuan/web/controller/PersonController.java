package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.entity.Person;
import com.xiaochuan.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/person/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("getPersonList")
    TraceResponse<List<Person>> getPersonList() {
        return TraceResponse.success(personService.getAllPersons());
    }

    @GetMapping("getPersonListByType")
    TraceResponse<List<Person>> getPersonListByType(@RequestParam int type) {
        return TraceResponse.success(personService.getPersonListByType(type));
    }

    @PostMapping("addPerson")
    TraceResponse<Person> addPerson(@RequestBody Person person) {
        if (StringUtils.isEmpty(person.getName()) || StringUtils.isEmpty(person.getIdCard())) {
            return TraceResponse.fail("姓名和身份证号不能为空");
        }
        TraceResponse res;
        Person dup = new Person();
        dup.setIdCard(person.getIdCard());
        if (personService.exists(dup)) {
            res = TraceResponse.fail("身份证号已经存在");
        } else {
            res = TraceResponse.success(personService.addPerson(person));

        }
        return res;
    }

    @PostMapping("deletePerson")
    TraceResponse<Person> deletePerson(@RequestParam int id) {
        personService.deletePerson(id);
        return TraceResponse.success();
    }

    @PostMapping("updatePerson")
    TraceResponse<Person> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return TraceResponse.success();
    }
}
