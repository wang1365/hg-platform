package com.hg.web.controller;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.GoodsBrand;
import com.hg.web.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:44
 * @description:
 */
@RestController
@RequestMapping("/web/goods")
public class GoodsBrandController {
    @Autowired
    private GoodsBrandService goodsBrandService;

    @GetMapping("getGoodsBrandList")
    HgResponse getGoodsBrandList() {
        return HgResponse.success(goodsBrandService.list(null));
    }

    @PostMapping("addGoodsBrand")
    HgResponse addGoodsBrand(@RequestBody GoodsBrand goodsBrand) {
        goodsBrandService.save(goodsBrand);
        return HgResponse.success();
    }

    @PostMapping("updateGoodsBrand")
    HgResponse updateGoodsBrand(@RequestBody GoodsBrand goodsBrand) {
        goodsBrandService.updateById(goodsBrand);
        return HgResponse.success();
    }

    @PostMapping("deleteGoodsBrand")
    HgResponse deleteGoodsBrand(int id) {
        goodsBrandService.removeById(id);
        return HgResponse.success();
    }
}