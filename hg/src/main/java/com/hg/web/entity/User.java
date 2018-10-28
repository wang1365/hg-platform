package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 16:28
 */
@Data
public class User {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private String nickName;
    private Integer type;
    private String platformCode;
    private String phone;
    private Boolean creditAudited;
    private Integer creditLevel;
    private Date registerTime;
    private Date createTime;
}