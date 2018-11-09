package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.ContainerDto;
import com.hg.web.entity.Container;
import java.util.List;

public interface ContainerService extends IService<Container> {
    List<ContainerDto> listContainers();
    List<Container> listContainersByAreaId(Long areaId);
}
