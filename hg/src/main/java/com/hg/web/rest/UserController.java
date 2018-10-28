package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.User;
import com.hg.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "addUser")
    HgResponse addUser(@RequestBody User user) {
        userService.save(user);
        return HgResponse.success();
    }

    @GetMapping(value = "/getUserList")
    List<User> getUserList() {
        return userService.list(null);
    }
}
