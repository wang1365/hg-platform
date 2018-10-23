package com.xiaochuan.web.service;

import com.xiaochuan.web.entity.PlantActionType;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/9/22 9:53
 */
public interface PlantActionTypeService {
    List<PlantActionType> getAllTypes();
    PlantActionType getTypeById(int id);
}