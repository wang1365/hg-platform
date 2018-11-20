package com.hg.web.entity;


import lombok.Data;

@Data
public class GoodsOutboundDetail {
    private Long outboundId;
    private Long goodsId;
    private Long amount;
}
