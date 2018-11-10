package com.hg.web.entity;


import lombok.Data;

@Data
public class GoodsInbound extends BaseEntity {
    // 入库货柜的片区ID
    private Long areaId;
    private String containerCode;
    private Long species;
    private Long amount;
}
