package com.hg.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.security.entity.SysUser;
import com.hg.security.repository.SysUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/1 20:08
 * @description:
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public SysUser findUserByName(String name) {
        SysUser user = new SysUser();
        user.setUserName(name);
        return this.getOne(new QueryWrapper<>(user));
    }
}