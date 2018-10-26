package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 16:28
 */
@Getter
@Setter
public class User {
    @JsonIgnore
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private String password;
    @JsonProperty("username")
    private String userName;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Boolean enabled;
    @JsonIgnore
    private Date passwordResetTime;
    @JsonIgnore
    private Date expiredTime;
    @JsonIgnore
    private List<Role> roles;
}