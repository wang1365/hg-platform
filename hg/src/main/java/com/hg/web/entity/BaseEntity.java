package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    Date createTime;
}