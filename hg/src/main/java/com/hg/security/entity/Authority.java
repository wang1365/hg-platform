package com.hg.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Authority {
    @TableId(type = IdType.AUTO)
    private Long id;

    private AuthorityName name;

    private List<SysUser> sysUsers;
}