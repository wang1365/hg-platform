package com.hg.web.entity;

import lombok.Data;

import java.util.Date;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 08:58
 * @description:
 */
@Data
public class Image extends BaseEntity {
    private Integer catId;
    private String name;
    private String localPath;
    private String urlPath;
    private Date createTime;
}