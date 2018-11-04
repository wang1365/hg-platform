package com.hg.web.entity;

import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 11:07
 * @description:
 */
@Data
public class Company extends BaseEntity {
    private String name;
    private String address;
    private String owner;
    private String telephone;
}
