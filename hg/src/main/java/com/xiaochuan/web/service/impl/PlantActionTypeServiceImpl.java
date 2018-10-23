package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.PlantActionTypeMapper;
import com.xiaochuan.web.entity.PlantActionType;
import com.xiaochuan.web.service.PlantActionTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/9/22 9:53
 */
@Service
@CacheConfig(cacheNames = "plantActionType")
@Slf4j
public class PlantActionTypeServiceImpl implements PlantActionTypeService {
    @Autowired
    private PlantActionTypeMapper typeMapper;

    @Override
    @Cacheable(key="'all'")
    public List<PlantActionType> getAllTypes() {
        List<PlantActionType> types = typeMapper.selectList(null);
        log.info("Get plant action types from db: {}", types.size());
        return types;
    }

    @Override
    public PlantActionType getTypeById(int id) {
        return typeMapper.selectById(id);
    }
}