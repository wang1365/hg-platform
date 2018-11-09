package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.ContainerDto;
import com.hg.web.entity.Container;
import com.hg.web.service.ContainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/container/")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @GetMapping("/getContainers")
    public HgResponse<List<ContainerDto>> getContainers() {
        return HgResponse.success(containerService.listContainers());
    }

    @GetMapping("/getContainersByAreaId")
    public HgResponse<List<Container>> getContainersByArea(@RequestParam Long areaId) {
        return HgResponse.success(containerService.listContainersByAreaId(areaId));
    }

    @PostMapping("/updateContainer")
    public HgResponse<ContainerDto> updateContainer(@RequestBody ContainerDto containerDto) {
        containerService.updateById(containerDto);
        return HgResponse.success(containerDto);
    }

    @PostMapping("/{containerId}/enable")
    public HgResponse enableContainer(@PathVariable Long containerId, @RequestParam Boolean enabled) {
        Container container = containerService.getById(containerId);
        container.setEnabled(enabled);
        return HgResponse.success(containerService.updateById(container));
    }

    @PostMapping("/addContainer")
    public HgResponse addContainer(@RequestBody ContainerDto containerDto) {
        return HgResponse.success(containerService.save(containerDto));
    }

}
