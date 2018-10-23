package com.xiaochuan.web.controller;

import com.xiaochuan.web.entity.User;
import com.xiaochuan.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    User addUser(@RequestBody User newUser) {
        int userId = userService.addUser(newUser.getUserName(), newUser.getPassword());
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    List<User> getUsers() {
        return userService.getUsers();
    }
}
