package com.hg.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hg.security.entity.Authority;
import com.hg.security.entity.SysUser;
import com.hg.security.repository.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser q = new SysUser();
        q.setUserName(username);
        SysUser user = userMapper.selectOne(new QueryWrapper<>(q));
        List<Authority> authorities = new ArrayList<>();

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user, authorities);
        }
    }
}
