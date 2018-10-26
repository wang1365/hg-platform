package com.hg.web.controller;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.Person;
import com.hg.web.service.PersonService;
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
    HgResponse<List<Person>> getPersonList() {
        return HgResponse.success(personService.getAllPersons());
    }

    @GetMapping("getPersonListByType")
    HgResponse<List<Person>> getPersonListByType(@RequestParam int type) {
        return HgResponse.success(personService.getPersonListByType(type));
    }

    @PostMapping("addPerson")
    HgResponse<Person> addPerson(@RequestBody Person person) {
        if (StringUtils.isEmpty(person.getName()) || StringUtils.isEmpty(person.getIdCard())) {
            return HgResponse.fail("姓名和身份证号不能为空");
        }
        HgResponse res;
        Person dup = new Person();
        dup.setIdCard(person.getIdCard());
        if (personService.exists(dup)) {
            res = HgResponse.fail("身份证号已经存在");
        } else {
            res = HgResponse.success(personService.addPerson(person));

        }
        return res;
    }

    @PostMapping("deletePerson")
    HgResponse<Person> deletePerson(@RequestParam int id) {
        personService.deletePerson(id);
        return HgResponse.success();
    }

    @PostMapping("updatePerson")
    HgResponse<Person> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return HgResponse.success();
    }
}
