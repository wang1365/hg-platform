package com.hg.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsOutboundDetailDto;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsOutboundDetail;
import com.hg.web.repository.GoodsOutboundDetailMapper;
import com.hg.web.service.GoodsOutboundDetailService;
import com.hg.web.service.GoodsService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsOutboundDetailServiceImpl extends ServiceImpl<GoodsOutboundDetailMapper, GoodsOutboundDetail> implements
    GoodsOutboundDetailService {

    @Autowired
    private GoodsService goodsService;

    @Override
    public List<GoodsOutboundDetailDto> listDetailsById(long id) {
        QueryWrapper<GoodsOutboundDetail> wrapper = new QueryWrapper<>();
        wrapper.in("outbound_id", id);
        List<GoodsOutboundDetail> details = this.list(wrapper);
        List<Long> goodsIds = details.stream()
                    .map(GoodsOutboundDetail::getGoodsId)
                    .collect(Collectors.toList());
        Map<Long, Goods> map = goodsService.listByIds(goodsIds)
                    .stream()
                    .collect(
                        Collectors.toMap(Goods::getId, Function.identity()));
        return details.stream()
                    .map(detail -> {
                        GoodsOutboundDetailDto dto = new GoodsOutboundDetailDto();
                        BeanUtils.copyProperties(detail, dto);
                        dto.setGoodsBarCode(map.get(detail.getGoodsId()).getBarCode());
                        dto.setGoodsName(map.get(detail.getGoodsId()).getName());
                        return dto;
                    })
                    .collect(Collectors.toList());
    }
}
