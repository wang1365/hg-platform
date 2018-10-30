package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/30 11:07
 * @description: 用户(微信、支付宝)
 */
@Data
public class User {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户类型 1：微信 2：支付宝
     */
    private Integer type;
    /**
     * 平台ID
     */
    private String platformCode;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 用户信用审核状态
     */
    private Boolean creditAudited;
    /**
     * 用户信用等级
     */
    private Integer creditLevel;
    /**
     * 用户注册时间
     */
    private Date registerTime;
    private Date createTime;
}