package com.hg.web.dto;

import com.hg.web.entity.GoodsInbound;
import java.util.Map;
import lombok.Data;

@Data
public class GoodsInboundDto extends GoodsInbound {

    private Map<String, Long> goods;

    public GoodsInbound toGoodInbound() {
        GoodsInbound inbound = new GoodsInbound();
        inbound.setContainerCode(this.getContainerCode());
        inbound.setPersonId(this.getPersonId());
        inbound.setAreaId(this.getAreaId());
        inbound.setSpecies(Long.valueOf(this.getGoods().size()));
        inbound.setAmount(this.getGoods().values().stream().mapToLong(Long::longValue).sum());
        return inbound;
    }

}
