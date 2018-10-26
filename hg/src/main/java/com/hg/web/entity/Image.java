package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 08:58
 * @description:
 */
@Data
public class Image {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private Integer catId;
    private String name;
    private String localPath;
    private String urlPath;
    private Date createTime;
}