package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
public class Person {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private String name;

    private Integer type;

    private String gender;

    private Date birthday;

    private String idCard;

    private String familyAddress;

    private String mobileNo;

    private String company;
}