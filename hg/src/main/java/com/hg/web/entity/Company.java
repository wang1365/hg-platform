package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 11:07
 * @description:
 */
@Data
public class Company {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String owner;
    private String telephone;
}
