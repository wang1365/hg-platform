package com.hg.web.service;

import com.hg.web.entity.User;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface UserService {
    int addUser(String username, String password);
    User getUserByName(String username);
    User getUserById(int id);
    List<User> getUsers();
}
