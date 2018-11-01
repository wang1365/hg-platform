package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="id")
public class Area {
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 片区名称
    private String name;
    // 启用状态
    private Boolean enabled;
    // 所属单位
    private Integer companyId;
    // 负责人
    private Integer headId;
    // 详细地址
    private String address;
    // 经度
    private Float longitude;
    // 纬度
    private Float latitude;
    // 备注
    private String comment;
}