package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.GoodsDTO;
import com.hg.web.entity.GoodsBrand;
import com.hg.web.entity.GoodsCategory;
import com.hg.web.repository.GoodsMapper;
import com.hg.web.entity.Goods;
import com.hg.web.service.GoodsBrandService;
import com.hg.web.service.GoodsCategoryService;
import com.hg.web.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
@CacheConfig(cacheNames = "goods")
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsBrandService brandService;

    @Autowired
    private GoodsCategoryService categoryService;

    @Override
    public List<GoodsDTO> listGoodsDetail() {
        List<Goods> items = list(null);
        List<Integer> brandIds = items.stream().map(Goods::getId).collect(Collectors.toList());
        Map<Integer, String> brandMap = brandService.listByIds(brandIds).stream()
                .collect(Collectors.toMap(GoodsBrand::getId, GoodsBrand::getName));
        Map<Integer, String> catMap = categoryService.listByIds(brandIds).stream()
                .collect(Collectors.toMap(GoodsCategory::getId, GoodsCategory::getName));

        return items.stream().map(goods -> {
            GoodsDTO dto = new GoodsDTO();
            BeanUtils.copyProperties(goods, dto);
            dto.setBrandName(brandMap.get(goods.getBrandId()));
            dto.setCatName(catMap.get(goods.getCatId()));
            return dto;
        }).collect(Collectors.toList());
    }
}
