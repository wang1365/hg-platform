package com.hg.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="id")
public class Area {
    private Integer id;
    // 片区名称
    private String name;
    // 启用状态
    private Boolean enabled;
    // 所属单位
    private String chargeOrg;
    // 负责人姓名
    private String chargeOwner;
    // 负责人手机号码
    private String ownerPhone;
    // 详细地址
    private String address;
    // 经度
    private Double longitude;
    // 纬度
    private Double latitude;
    // 备注
    private String comment;
}