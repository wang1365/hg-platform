package com.hg.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hg.web.common.HgResponse;
import com.hg.web.entity.Area;
import com.hg.web.service.AreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/area/")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/getAreaList")
    public HgResponse<List<Area>> getAreaList() {
        return HgResponse.success(areaService.list(new QueryWrapper<Area>()));
    }
}
