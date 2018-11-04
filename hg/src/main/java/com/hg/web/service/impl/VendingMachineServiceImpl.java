package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.VendingMachineDto;
import com.hg.web.entity.Area;
import com.hg.web.entity.Person;
import com.hg.web.entity.VendingMachine;
import com.hg.web.repository.VendingMachineMapper;
import com.hg.web.service.AreaService;
import com.hg.web.service.PersonService;
import com.hg.web.service.VendingMachineService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendingMachineServiceImpl extends ServiceImpl<VendingMachineMapper, VendingMachine> implements VendingMachineService {

    @Autowired
    private PersonService personService;

    @Autowired
    private AreaService areaService;

    @Override
    public List<VendingMachineDto> listVendingMachines() {
        List<VendingMachine> machines = this.list(null);
        List<Long> personIds = machines.stream()
                .flatMap(m -> Stream.of(m.getHeadId(), m.getDistributionId()))
                .collect(Collectors.toList());
        Map<Long, String> persons = personService.listByIds(personIds).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Person::getId, Person::getName));

        List<Long> areaIds = machines.stream().map(VendingMachine::getAreaId).collect(Collectors.toList());
        Map<Long, String> areas = areaService.listByIds(areaIds).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Area::getId, Area::getName));

        return machines.stream().map(machine -> {
            VendingMachineDto machineDto = new VendingMachineDto();
            BeanUtils.copyProperties(machine, machineDto);
            machineDto.setAreaName(areas.get(machine.getAreaId()));
            machineDto.setHeadName(persons.get(machine.getHeadId()));
            machineDto.setDistributionName(persons.get(machine.getDistributionId()));
            return machineDto;
        }).collect(Collectors.toList());
    }
}
