package com.xiaochuan.web.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaochuan.web.entity.Plant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Mapper
public interface PlantMapper extends BaseMapper<Plant> {
}