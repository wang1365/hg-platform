package com.hg.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="id")
public class Area extends BaseEntity {
    // 片区名称
    private String name;
    // 启用状态
    private Boolean enabled;
    // 所属单位
    private Long companyId;
    // 负责人
    private Long headId;
    // 详细地址
    private String address;
    // 经度
    private Float longitude;
    // 纬度
    private Float latitude;
    // 备注
    private String comment;
}