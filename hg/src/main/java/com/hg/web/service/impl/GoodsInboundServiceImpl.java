package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsInboundDto;
import com.hg.web.entity.GoodsInbound;
import com.hg.web.entity.GoodsInboundDetail;
import com.hg.web.repository.GoodsInboundMapper;
import com.hg.web.service.GoodsInboundDetailService;
import com.hg.web.service.GoodsInboundService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsInboundServiceImpl extends ServiceImpl<GoodsInboundMapper, GoodsInbound> implements
    GoodsInboundService {

    @Autowired
    private GoodsInboundDetailService goodsInboundDetailService;


    @Override
    public boolean inbound(GoodsInboundDto goodsInboundDto) {
        // check user type

        // check/update whether to match label; RFID读取的仅仅是商品条码，还是电子标签??
        GoodsInbound inbound = goodsInboundDto.toGoodInbound();
        this.save(inbound);

        Long id = inbound.getId();
        goodsInboundDetailService.saveBatch(
                goodsInboundDto.getGoods()
                    .entrySet()
                    .stream()
                    .map(entry -> {
                        GoodsInboundDetail detail = new GoodsInboundDetail();
                        detail.setInboundId(id);
                        detail.setGoodsId(entry.getKey());
                        detail.setAmount(entry.getValue());
                        return detail;
                    })
                    .collect(Collectors.toList()));

        return true;
    }
}
