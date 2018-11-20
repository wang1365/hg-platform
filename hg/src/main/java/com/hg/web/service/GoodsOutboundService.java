package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsOutboundDto;
import com.hg.web.entity.GoodsOutbound;

public interface GoodsOutboundService extends IService<GoodsOutbound> {

    boolean outbound(GoodsOutboundDto goodsOutboundDto);
}
