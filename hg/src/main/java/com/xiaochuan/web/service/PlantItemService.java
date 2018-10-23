package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.PlantItemDTO;
import com.xiaochuan.web.entity.Plant;
import com.xiaochuan.web.entity.PlantItem;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface PlantItemService {
    PlantItemDTO getPlantItemById(long id);
    List<PlantItemDTO> getPlantItemByPlantId(long plantId);
    List<PlantItemDTO> getPickListByPerson(int personId);
    List<PlantItem> getPickListByPlant(long plant);

    PlantItem addPlantItem(PlantItem plantItem);
    void deletePlantItem(long id);
}