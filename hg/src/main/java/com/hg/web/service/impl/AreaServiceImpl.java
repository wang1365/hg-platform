package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.AreaDto;
import com.hg.web.entity.Area;
import com.hg.web.entity.Company;
import com.hg.web.entity.Person;
import com.hg.web.repository.AreaMapper;
import com.hg.web.service.AreaService;
import com.hg.web.service.CompanyService;
import com.hg.web.service.PersonService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PersonService personService;

    @Override
    public List<AreaDto> listAreas() {
        List<Area> areas = list(null);

        List<Integer> companyIds = areas.stream().map(Area::getCompanyId).collect(Collectors.toList());
        Map<Integer, String> companies = companyService.listByIds(companyIds).stream()
                .collect(Collectors.toMap(Company::getId, Company::getName));

        List<Integer> headIds = areas.stream().map(Area::getHeadId).collect(Collectors.toList());
        System.out.println(headIds);
        Map<Integer, Person> heads = personService.listByIds(headIds).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(heads);

        return areas.stream().map(area -> {
            AreaDto dto = new AreaDto();
            BeanUtils.copyProperties(area, dto);
            dto.setCompanyName(companies.get(area.getCompanyId()));
            if (Objects.nonNull(area.getHeadId())) {
                dto.setHeadName(heads.get(area.getHeadId()).getName());
                dto.setHeadPhone(heads.get(area.getHeadId()).getMobileNo());
            }
            return dto;
        }).collect(Collectors.toList());
    }
}
