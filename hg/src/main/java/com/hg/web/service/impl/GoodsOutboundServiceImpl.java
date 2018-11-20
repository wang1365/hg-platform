package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsOutboundDto;
import com.hg.web.entity.Area;
import com.hg.web.entity.Container;
import com.hg.web.entity.GoodsOutbound;
import com.hg.web.entity.GoodsOutboundDetail;
import com.hg.web.repository.GoodsOutboundMapper;
import com.hg.web.service.AreaService;
import com.hg.web.service.ContainerService;
import com.hg.web.service.GoodsOutboundDetailService;
import com.hg.web.service.GoodsOutboundService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsOutboundServiceImpl extends ServiceImpl<GoodsOutboundMapper, GoodsOutbound> implements
    GoodsOutboundService {

    @Autowired
    private AreaService areaService;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private GoodsOutboundDetailService goodsOutboundDetailService;

    @Override
    public List<GoodsOutboundDto> listDetail() {
        List<GoodsOutbound> outbounds = this.list(null);
        Map<Long, String> areaNames =
                areaService.listAreas()
                    .stream()
                    .collect(Collectors.toMap(Area::getId, Area::getName));
        Map<String, String> containerNames =
                containerService.listContainers()
                    .stream()
                    .collect(Collectors.toMap(Container::getCode, Container::getName));
        return outbounds.stream()
                    .map(outbound -> {
                        GoodsOutboundDto dto = new GoodsOutboundDto();
                        BeanUtils.copyProperties(outbound, dto);
                        dto.setAreaName(areaNames.get(outbound.getAreaId()));
                        dto.setContainerName(containerNames.get(outbound.getContainerCode()));
                        return dto;
                    })
                    .collect(Collectors.toList());
    }

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
