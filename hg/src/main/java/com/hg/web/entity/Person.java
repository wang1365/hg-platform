package com.hg.web.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
public class Person extends BaseEntity {

    private String name;

    private Integer type;

    private String gender;

    private Date birthday;

    private String idCard;

    private String familyAddress;

    private String mobileNo;

    private String company;
}