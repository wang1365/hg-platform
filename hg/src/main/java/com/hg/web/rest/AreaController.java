package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.AreaDto;
import com.hg.web.entity.Area;
import com.hg.web.service.AreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/area/")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/getAreaList")
    public HgResponse<List<AreaDto>> getAreaList() {
        return HgResponse.success(areaService.listAreas());
    }

    @PostMapping("/updateArea")
    public HgResponse<Area> updateArea(@RequestBody Area area) {
        areaService.updateById(area);
        return HgResponse.success(area);
    }

    @PostMapping("/addArea")
    public HgResponse addArea(@RequestBody AreaDto areaDto) {
        return HgResponse.success(areaService.save(areaDto));
    }

}
