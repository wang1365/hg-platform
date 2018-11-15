package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.GoodsLabelDTO;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsLabel;
import com.hg.web.service.GoodsLabelService;
import com.hg.web.service.GoodsService;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 00:27
 * @description:
 */
@RestController
@RequestMapping("/web/goods")
public class GoodsLabelController {
    @Autowired
    private GoodsLabelService labelService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("getGoodsLabelList")
    HgResponse<List<GoodsLabelDTO>> getGoodsLabelList() {
        return HgResponse.success(labelService.listDetail());
    }

    @PostMapping("addGoodsLabel")
    HgResponse addGoodsLabel(@RequestBody GoodsLabel goodsLabel) {
//        if (goodsService.selectByBarCode(goodsLabel.getBarCode()) != null) {
//            return HgResponse.fail("该条形码已经添加过标签");
//        }
        List<GoodsLabel> goodsLabels =
            Stream.of(goodsLabel.getLabelCode().split(",|\n"))
                .distinct()
                // .filter by other conditions
                .map(labelCode -> {
                    GoodsLabel label = new GoodsLabel();
                    BeanUtils.copyProperties(goodsLabel, label);
                    label.setLabelCode(labelCode);
                    return label;
                })
                .collect(Collectors.toList());

        labelService.saveBatch(goodsLabels);
        return HgResponse.success();
    }

    @PostMapping("updateGoodsLabel")
    HgResponse updateGoodsLabel(@RequestBody GoodsLabel goodsLabel) {
        labelService.updateById(goodsLabel);
        return HgResponse.success();
    }

    @PostMapping("deleteGoodsLabel")
    HgResponse deleteGoodsLabel(long id) {
        labelService.removeById(id);
        return HgResponse.success();
    }
}