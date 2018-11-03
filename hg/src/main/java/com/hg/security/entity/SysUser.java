package com.hg.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 16:28
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private String password;
    private String userName;
    private String email;
    private Date createTime;
    private Boolean enabled;
    private Date passwordResetTime;
    private Date expiredTime;
}