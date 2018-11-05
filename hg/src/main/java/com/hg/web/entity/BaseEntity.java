package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/4 15:23
 * @description:
 */
@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    Long id;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    Date createTime;
}