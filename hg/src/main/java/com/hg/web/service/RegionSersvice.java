package com.hg.web.service;

import com.hg.web.entity.Region;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface RegionSersvice {
    List<Region> getRegions(Long parentId, Integer level);
}