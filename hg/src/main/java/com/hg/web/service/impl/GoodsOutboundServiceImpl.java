package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsOutboundDto;
import com.hg.web.entity.GoodsOutbound;
import com.hg.web.entity.GoodsOutboundDetail;
import com.hg.web.repository.GoodsOutboundMapper;
import com.hg.web.service.GoodsOutboundDetailService;
import com.hg.web.service.GoodsOutboundService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsOutboundServiceImpl extends ServiceImpl<GoodsOutboundMapper, GoodsOutbound> implements
    GoodsOutboundService {

    @Autowired
    private GoodsOutboundDetailService goodsOutboundDetailService;

    @Override
    public boolean outbound(GoodsOutboundDto goodsOutboundDto) {
        // check user type

        // check/update whether to match label; RFID读取的仅仅是商品条码，还是电子标签??
        GoodsOutbound outbound = goodsOutboundDto.toGoodOutbound();
        this.save(outbound);

        Long id = outbound.getId();
        goodsOutboundDetailService.saveBatch(
            goodsOutboundDto.getGoods()
                .entrySet()
                .stream()
                .map(entry -> {
                    GoodsOutboundDetail detail = new GoodsOutboundDetail();
                    detail.setOutboundId(id);
                    detail.setGoodsId(entry.getKey());
                    detail.setAmount(entry.getValue());
                    return detail;
                })
                .collect(Collectors.toList()));

        return true;
    }
}
