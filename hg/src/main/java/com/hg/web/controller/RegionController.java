package com.hg.web.controller;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.Region;
import com.hg.web.service.RegionSersvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/region")
public class RegionController {
    private RegionSersvice regionSersvice;

    public RegionController(RegionSersvice regionSersvice) {
        this.regionSersvice = regionSersvice;
    }

    @GetMapping("/list")
    HgResponse<List<Region>> getRegions(@RequestParam(defaultValue = "-1") Long parentId,
                                        @RequestParam Integer level) {
        if (parentId == -1) {
            parentId = null;
        }
        List<Region> regions = regionSersvice.getRegions(parentId, level);
        return HgResponse.success(regions);
    }
}