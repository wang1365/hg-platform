package com.hg.web.entity;


import lombok.Data;

@Data
public class GoodsInboundDetail {
    private Long inboundId;
    private String barCode;
    private Long amount;
}
