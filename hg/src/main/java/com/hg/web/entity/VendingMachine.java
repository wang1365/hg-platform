package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`vm`")
public class VendingMachine {
    private Integer id;
    private String code;
    private String deviceMode;
    private Boolean enabled;
    private Boolean run;

    // 片区
    private Integer areaId;

    // 负责人
    private Integer headId;

    // 配送人员
    private Integer distributionId;

    private String address;
    private Float longitude;
    private Float latitude;
    private String comment;
}
