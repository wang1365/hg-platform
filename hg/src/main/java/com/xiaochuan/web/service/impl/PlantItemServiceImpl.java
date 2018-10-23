package com.xiaochuan.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaochuan.consts.PlantItemActionType;
import com.xiaochuan.web.repository.PlantItemMapper;
import com.xiaochuan.web.dto.PlantItemDTO;
import com.xiaochuan.web.entity.Person;
import com.xiaochuan.web.entity.PlantActionType;
import com.xiaochuan.web.entity.PlantItem;
import com.xiaochuan.web.service.PersonService;
import com.xiaochuan.web.service.PlantActionTypeService;
import com.xiaochuan.web.service.PlantItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Xiaochuan Wang
 * @date: 2018/9/22 17:28
 * @Description:
 */
@Service
@Slf4j
public class PlantItemServiceImpl implements PlantItemService {
    @Autowired
    private PlantItemMapper plantItemMapper;
    @Autowired
    private PersonService personService;
    @Autowired
    private PlantActionTypeService typeService;

    private List<PlantActionType> types;

    @Override
    public PlantItemDTO getPlantItemById(long id) {
        PlantItem plantItem = plantItemMapper.selectById(id);
        types = typeService.getAllTypes();

        return getPlantItemDTO(plantItem);
    }

    private PlantActionType findAction(List<PlantActionType> types, int id) {
        for (PlantActionType type : types) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    private PlantItemDTO getPlantItemDTO(PlantItem plantItem) {
        PlantItemDTO plantItemDTO = null;
        if (plantItem != null) {
            plantItemDTO = new PlantItemDTO();
            BeanUtils.copyProperties(plantItem, plantItemDTO);
            plantItemDTO.setActionName(findAction(types, plantItem.getActionType()).getName());

            if (plantItem.getActionFarmerId() != null) {
                Person person = personService.getPersonById(plantItem.getActionFarmerId());
                plantItemDTO.setFarmerName(person.getName());
            }
        }
        return plantItemDTO;
    }

    @Override
    public List<PlantItemDTO> getPlantItemByPlantId(long plantId) {
        PlantItem item = new PlantItem();
        item.setPlantId(plantId);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.setEntity(item);

        List<PlantItem> plants = plantItemMapper.selectList(wrapper);
        types = typeService.getAllTypes();
        List<PlantItemDTO> dtos = plants.stream().map(plantItem ->
                getPlantItemDTO(plantItem)
        ).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<PlantItemDTO> getPickListByPerson(int personId) {
        PlantItem item = new PlantItem();
        item.setActionFarmerId(personId);
        item.setActionType(PlantItemActionType.PICK.getCode());
        QueryWrapper wrapper = new QueryWrapper(item);
        List<PlantItem> items = plantItemMapper.selectList(wrapper);

        return items.stream().map(pi -> {
            PlantItemDTO dto = new PlantItemDTO();
            BeanUtils.copyProperties(pi, dto);

            Person person = personService.getPersonById(pi.getActionFarmerId());
            dto.setFarmerName(person != null ? person.getName() : "");
            PlantActionType type = typeService.getTypeById(dto.getActionType());
            dto.setActionName(type != null ? type.getName() : "");
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PlantItem> getPickListByPlant(long plant) {
        PlantItem item = new PlantItem();
        item.setPlantId(plant);
        item.setActionType(PlantItemActionType.PICK.getCode());
        QueryWrapper wrapper = new QueryWrapper(item);
        return plantItemMapper.selectList(wrapper);
    }

    @Override
    public PlantItem addPlantItem(PlantItem plantItem) {
        plantItemMapper.insert(plantItem);
        return plantItem;
    }

    @Override
    public void deletePlantItem(long id) {
        plantItemMapper.deleteById(id);
    }
}