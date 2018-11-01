package com.hg.web.entity;

public class VendingMachine {
    private Integer id;
    private String code;
    private String name;
    private String deviceMode;
    private Boolean enabled;

    // 片区
    private Integer areaId;
    private String areaName;

    // 负责人
    private Integer headId;
    private String headName;

    // 配送人员
    private Integer distributionId;
    private Integer distributionName;

    private String address;
    private Float longitude;
    private Float latitude;
    private String comment;

}
