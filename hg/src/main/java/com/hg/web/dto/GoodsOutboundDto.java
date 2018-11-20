package com.hg.web.dto;

import com.hg.web.entity.GoodsOutbound;
import java.util.Map;
import lombok.Data;

@Data
public class GoodsOutboundDto extends GoodsOutbound {

    private String areaName;
    private String containerName;
    private String containerCode;


    private Map<Long, Long> goods;

    public GoodsOutbound toGoodOutbound() {
        GoodsOutbound outbound = new GoodsOutbound();
        outbound.setContainerCode(this.getContainerCode());
        outbound.setAreaId(this.getAreaId());
        outbound.setSpecies(Long.valueOf(this.getGoods().size()));
        outbound.setAmount(this.getGoods().values().stream().mapToLong(Long::longValue).sum());
        return outbound;
    }

}
