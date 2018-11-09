package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`container`")
public class Container extends BaseEntity {
    private String code;
    private String name;
    private String deviceMode;
    private Boolean enabled;
    private Boolean run;

    // 片区
    private Long areaId;

    // 负责人
    private Long headId;

    // 配送人员
    private Long distributionId;

    private String address;
    private Float longitude;
    private Float latitude;
    private String comment;
}
