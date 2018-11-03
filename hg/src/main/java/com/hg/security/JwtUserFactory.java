package com.hg.security;

import com.hg.security.entity.Authority;
import com.hg.security.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(SysUser user, List<Authority> authorities) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(authorities),
                user.getEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
