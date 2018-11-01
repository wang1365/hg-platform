package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.AreaDto;
import com.hg.web.entity.Area;
import java.util.List;


public interface AreaService extends IService<Area> {
    List<AreaDto> listAreas();
}
