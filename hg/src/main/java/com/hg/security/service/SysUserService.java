package com.hg.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.security.entity.SysUser;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/1 20:07
 * @description:
 */
public interface SysUserService extends IService<SysUser> {
    SysUser findUserByName(String name);
}