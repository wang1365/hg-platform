package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.PlantDTO;
import com.xiaochuan.web.entity.Plant;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface PlantService {
    List<PlantDTO> getPlantByGoodsAndFarmer(int goodsId, int farmerId);
    List<PlantDTO> getPlantByGoods(int goodsId);
    List<PlantDTO> getPlantByFarmer(int farmerId);
    List<PlantDTO> getAllPlant();
    Plant addPlant(Plant plant);
    Plant updatePlant(Plant plant);
    PlantDTO getPlantById(long id);
    void deletePlantById(long id);
}
