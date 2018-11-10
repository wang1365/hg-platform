package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsInboundDto;
import com.hg.web.entity.GoodsInbound;

public interface GoodsInboundService extends IService<GoodsInbound> {

    boolean inbound(GoodsInboundDto goodsInboundDto);
}
