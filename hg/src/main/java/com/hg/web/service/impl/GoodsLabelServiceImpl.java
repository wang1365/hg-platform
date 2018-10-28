package com.hg.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsLabelDTO;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsLabel;
import com.hg.web.repository.GoodsLabelMapper;
import com.hg.web.service.GoodsLabelService;
import com.hg.web.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:40
 * @description:
 */
@Service
public class GoodsLabelServiceImpl extends ServiceImpl<GoodsLabelMapper, GoodsLabel> implements GoodsLabelService {
    @Autowired
    private GoodsService goodsService;

    @Override
    public List<GoodsLabelDTO> listDetail() {
        List<GoodsLabel> labels = list(null);
        List<String> barCodes = labels.stream().map(GoodsLabel::getBarCode).collect(Collectors.toList());
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.in("bar_code", barCodes);
        Map<String, Goods> goodsMap = goodsService.list(wrapper).stream()
                .collect(Collectors.toMap(Goods::getBarCode, v->v));
        return labels.stream().map(label -> {
            GoodsLabelDTO dto = new GoodsLabelDTO();
            BeanUtils.copyProperties(label, dto);
            Goods goods = goodsMap.get(label.getBarCode());
            BeanUtils.copyProperties(goods, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}
