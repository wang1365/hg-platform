package com.hg.web.dto;

import com.hg.web.entity.GoodsInbound;
import java.util.Map;
import lombok.Data;

@Data
public class GoodsInboundDto extends GoodsInbound {

    private String areaName;
    private String containerName;
    private String containerCode;

    private Map<Long, Long> goods;

    public GoodsInbound toGoodInbound() {
        GoodsInbound inbound = new GoodsInbound();
        inbound.setContainerCode(this.getContainerCode());
        inbound.setAreaId(this.getAreaId());
        inbound.setSpecies(Long.valueOf(this.getGoods().size()));
        inbound.setAmount(this.getGoods().values().stream().mapToLong(Long::longValue).sum());
        return inbound;
    }

}
