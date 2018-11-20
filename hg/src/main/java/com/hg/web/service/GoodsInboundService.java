package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsInboundDto;
import com.hg.web.entity.GoodsInbound;
import java.util.List;

public interface GoodsInboundService extends IService<GoodsInbound> {

    List<GoodsInboundDto> listDetail();
    boolean inbound(GoodsInboundDto goodsInboundDto);
}
