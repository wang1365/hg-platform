package com.hg.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.ContainerDto;
import com.hg.web.entity.Area;
import com.hg.web.entity.Person;
import com.hg.web.entity.Container;
import com.hg.web.repository.ContainerMapper;
import com.hg.web.service.AreaService;
import com.hg.web.service.PersonService;
import com.hg.web.service.ContainerService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContainerServiceImpl extends ServiceImpl<ContainerMapper, Container> implements
    ContainerService {

    @Autowired
    private PersonService personService;

    @Autowired
    private AreaService areaService;

    @Override
    public List<ContainerDto> listContainers() {
        List<Container> containers = this.list(null);
        List<Long> personIds = containers.stream()
                .flatMap(m -> Stream.of(m.getHeadId(), m.getDistributionId()))
                .collect(Collectors.toList());
        Map<Long, String> persons = personService.listByIds(personIds).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Person::getId, Person::getName));

        List<Long> areaIds = containers.stream().map(Container::getAreaId).collect(Collectors.toList());
        Map<Long, String> areas = areaService.listByIds(areaIds).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Area::getId, Area::getName));

        return containers.stream().map(container -> {
            ContainerDto containerDto = new ContainerDto();
            BeanUtils.copyProperties(container, containerDto);
            containerDto.setAreaName(areas.get(container.getAreaId()));
            containerDto.setHeadName(persons.get(container.getHeadId()));
            containerDto.setDistributionName(persons.get(container.getDistributionId()));
            return containerDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Container> listContainersByAreaId(Long areaId) {
        Container container = new Container();
        container.setAreaId(areaId);
        return list(new QueryWrapper<>(container));
    }
}
