package com.xiaochuan.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/9/21 20:36
 * @description:
 */
@Data
public class Qualification {
    @TableId(value = "id", type= IdType.AUTO)
    Integer id;
    String path;
    Integer companyId;
}