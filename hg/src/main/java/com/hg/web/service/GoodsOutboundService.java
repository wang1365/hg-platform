package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsOutboundDto;
import com.hg.web.entity.GoodsOutbound;
import java.util.List;

public interface GoodsOutboundService extends IService<GoodsOutbound> {

    List<GoodsOutboundDto> listDetail();
    boolean outbound(GoodsOutboundDto goodsOutboundDto);
}
