package com.xiaochuan.web.repository;

import com.xiaochuan.web.entity.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Mapper
public interface RegionMapper {
    List<Region> selectByParentIdAndLevel(@Param("parentId") Long parentId, @Param("level") Integer level);
}