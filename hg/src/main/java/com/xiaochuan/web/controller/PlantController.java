package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.dto.PlantDTO;
import com.xiaochuan.web.dto.PlantItemDTO;
import com.xiaochuan.web.entity.Plant;
import com.xiaochuan.web.entity.PlantActionType;
import com.xiaochuan.web.entity.PlantItem;
import com.xiaochuan.web.request.PlantRequest;
import com.xiaochuan.web.service.PlantActionTypeService;
import com.xiaochuan.web.service.PlantItemService;
import com.xiaochuan.web.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/9/21 9:53
 */
@RestController
@RequestMapping("/web/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantActionTypeService typeService;

    @Autowired
    private PlantItemService plantItemService;

    @Autowired
    private PlantItemService itemService;


    @GetMapping("list")
    TraceResponse<List<PlantDTO>> getAllPlant(@RequestParam(defaultValue = "-1") int goodsId,
                                              @RequestParam(defaultValue = "-1") int farmerId) {
        List<PlantDTO> plants;
        if (goodsId == -1 && farmerId == -1) {
            plants = plantService.getAllPlant();
        } else if (goodsId == -1 && farmerId != -1) {
            plants = plantService.getPlantByFarmer(farmerId);
        } else if (goodsId != -1 && farmerId == -1){
            plants = plantService.getPlantByGoods(goodsId);
        } else {
            plants = plantService.getPlantByGoodsAndFarmer(goodsId, farmerId);
        }
        return TraceResponse.success(plants);
    }

    @GetMapping("getPlantItemByPlant")
    TraceResponse<List<PlantItemDTO>> getPlantItemByPlant(@RequestParam long plantId) {
        return TraceResponse.success(plantItemService.getPlantItemByPlantId(plantId));
    }

    @PostMapping("deletePlant")
    TraceResponse deletePlant(@RequestParam long id) {
        plantService.deletePlantById(id);
        return TraceResponse.success();
    }

    @PostMapping(value = "addPlant", consumes = "application/json")
    TraceResponse<Plant> addPlant(@RequestBody PlantRequest plantRequest) {
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantRequest, plant);
        String yearText = plantRequest.getYear().substring(0, 4);
        plant.setYear(Integer.parseInt(yearText));
        plantService.addPlant(plant);
        return TraceResponse.success(plant);
    }

    @PostMapping(value = "updatePlant", consumes = "application/json")
    TraceResponse<Plant> updatePlant(@RequestBody Plant plant) {
        plantService.updatePlant(plant);
        return TraceResponse.success(plant);
    }

    @PostMapping(value = "addPlantItem", consumes = "application/json")
    TraceResponse<PlantItem> addPlantItem(@RequestBody PlantItem plantItem) {
        PlantItem item = plantItemService.addPlantItem(plantItem);
        return TraceResponse.success(item);
    }

    @PostMapping("deletePlantItemById")
    TraceResponse deletePlantItemById(@RequestParam long id) {
        plantItemService.deletePlantItem(id);
        return TraceResponse.success();
    }

    @GetMapping("getPlantActionTypeList")
    TraceResponse<List<PlantActionType>> getPlantActionTypeList() {
        return TraceResponse.success(typeService.getAllTypes());
    }

    @GetMapping("getPickListByPerson")
    TraceResponse<List<PlantItem>> getPickListByPerson(@RequestParam int personId) {
        return TraceResponse.success(plantItemService.getPickListByPerson(personId));
    }

    @GetMapping("getPickListByPlant")
    TraceResponse<List<PlantItem>> getPickListByPlant(@RequestParam int plantId) {
        return TraceResponse.success(plantItemService.getPickListByPerson(plantId));
    }

    @GetMapping("getPlantListByPerson")
    TraceResponse<List<PlantItem>> getPlantListByPerson(@RequestParam int personId) {
        return TraceResponse.success(plantService.getPlantByFarmer(personId));
    }
}