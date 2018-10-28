package com.hg.web.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.repository.UserMapper;
import com.hg.web.entity.User;
import com.hg.web.service.UserService;
import org.springframework.stereotype.Service;


/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
