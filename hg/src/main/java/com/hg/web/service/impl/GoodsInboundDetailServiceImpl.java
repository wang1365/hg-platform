package com.hg.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsInboundDetailDto;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsInboundDetail;
import com.hg.web.repository.GoodsInboundDetailMapper;
import com.hg.web.service.GoodsInboundDetailService;
import com.hg.web.service.GoodsService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsInboundDetailServiceImpl extends ServiceImpl<GoodsInboundDetailMapper, GoodsInboundDetail> implements
    GoodsInboundDetailService {

    @Autowired
    private GoodsService goodsService;

    @Override
    public List<GoodsInboundDetailDto> listDetailsById(long id) {
        QueryWrapper<GoodsInboundDetail> wrapper = new QueryWrapper<>();
        wrapper.in("inbound_id", id);
        List<GoodsInboundDetail> details = this.list(wrapper);
        List<Long> goodsIds = details.stream()
                                    .map(GoodsInboundDetail::getGoodsId).collect(Collectors.toList());
        Map<Long, Goods> map = goodsService.listByIds(goodsIds)
                                    .stream()
                                    .collect(
                                        Collectors.toMap(Goods::getId, Function.identity()));
        return details.stream()
                        .map(detail -> {
                           GoodsInboundDetailDto dto = new GoodsInboundDetailDto();
                            BeanUtils.copyProperties(detail, dto);
                            dto.setGoodsBarCode(map.get(detail.getGoodsId()).getBarCode());
                            dto.setGoodsName(map.get(detail.getGoodsId()).getName());
                            return dto;
                        })
                        .collect(Collectors.toList());
    }
}
