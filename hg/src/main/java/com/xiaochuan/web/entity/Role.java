package com.xiaochuan.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 16:28
 */
@Data
public class Role {
    @TableId(value = "id", type= IdType.AUTO)
    private int id;
    private String name;
}
