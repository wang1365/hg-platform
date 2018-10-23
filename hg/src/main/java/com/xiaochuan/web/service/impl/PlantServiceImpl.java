package com.xiaochuan.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaochuan.web.repository.GoodsMapper;
import com.xiaochuan.web.repository.PersonMapper;
import com.xiaochuan.web.repository.PlantMapper;
import com.xiaochuan.web.dto.PlantDTO;
import com.xiaochuan.web.entity.Goods;
import com.xiaochuan.web.entity.Person;
import com.xiaochuan.web.entity.Plant;
import com.xiaochuan.web.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
public class PlantServiceImpl implements PlantService {
    private PlantMapper plantMapper;
    private GoodsMapper goodsMapper;
    private PersonMapper personMapper;

    @Autowired
    public PlantServiceImpl(PlantMapper plantMapper, GoodsMapper goodsMapper, PersonMapper personMapper) {
        this.plantMapper = plantMapper;
        this.goodsMapper = goodsMapper;
        this.personMapper = personMapper;
    }


    @Override
    public List<PlantDTO> getPlantByGoodsAndFarmer(int goodsId, int farmerId) {
        Person person = this.getFarmer(farmerId);
        Goods goods = this.getGoods(goodsId);
        Plant plant = new Plant();
        plant.setGoodsId(goodsId);
        plant.setFarmerId(farmerId);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.setEntity(plant);
        List<Plant> plants = plantMapper.selectList(wrapper);
        return plants.stream().map(plt -> {
            PlantDTO dto = new PlantDTO();
            BeanUtils.copyProperties(plt, dto);
            dto.setGoodsName(goods.getName());
            dto.setFarmerName(person.getName());
            return dto;
        }).collect(Collectors.toList());

    }

    @Override
    public List<PlantDTO> getPlantByGoods(int goodsId) {
        Goods goods = this.getGoods(goodsId);
        Plant plant = new Plant();
        plant.setGoodsId(goodsId);
        QueryWrapper wrapper = new QueryWrapper();
        List<Plant> plants = plantMapper.selectList(wrapper);
        List<PlantDTO> dtos = plants.stream().map(plt -> {
            PlantDTO dto = new PlantDTO();
            BeanUtils.copyProperties(plt, dto);
            dto.setGoodsName(goods.getName());
            dto.setFarmerName(this.getFarmer(plt.getFarmerId()).getName());
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<PlantDTO> getPlantByFarmer(int farmerId) {
        Person person = this.getFarmer(farmerId);
        Plant plant = new Plant();
        plant.setFarmerId(farmerId);
        QueryWrapper wrapper = new QueryWrapper(plant);
        List<Plant> plants = plantMapper.selectList(wrapper);
        List<PlantDTO> dtos = plants.stream().map(plt -> {
            PlantDTO dto = new PlantDTO();
            BeanUtils.copyProperties(plt, dto);
            dto.setGoodsName(this.getGoods(plt.getGoodsId()).getName());
            dto.setFarmerName(person.getName());
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<PlantDTO> getAllPlant() {
        List<Plant> plants = plantMapper.selectList(null);
        List<PlantDTO> dtos = plants.stream().map(plant -> {
            PlantDTO dto = new PlantDTO();
            BeanUtils.copyProperties(plant, dto);
            dto.setGoodsName(this.getGoods(plant.getGoodsId()).getName());
            dto.setFarmerName(this.getFarmer(plant.getFarmerId()).getName());
            return dto;
        }).collect(Collectors.toList());
        return dtos;

    }

    @Override
    public Plant addPlant(Plant plant) {
        plantMapper.insert(plant);
        return plant;
    }

    @Override
    public Plant updatePlant(Plant plant) {
        plantMapper.updateById(plant);
        return plant;
    }

    private Person getFarmer(int farmerId) {
        return personMapper.selectById(farmerId);
    }

    private Goods getGoods(int goodsId) {
        return goodsMapper.selectById(goodsId);
    }

    @Override
    public PlantDTO getPlantById(long id) {
        Plant plant = plantMapper.selectById(id);
        PlantDTO dto = null;
        if (plant != null) {
            Goods goods = this.getGoods(plant.getGoodsId());
            Person person = this.getFarmer(plant.getFarmerId());
            dto = new PlantDTO();
            BeanUtils.copyProperties(plant, dto);
            dto.setFarmerName(person.getName());
            dto.setGoodsName(goods.getName());
        }
        return dto;
    }

    @Override
    public void deletePlantById(long id) {
        plantMapper.deleteById(id);
    }
}