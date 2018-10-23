package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.RegionMapper;
import com.xiaochuan.web.entity.Region;
import com.xiaochuan.web.service.RegionSersvice;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
public class RegionServiceImpl implements RegionSersvice {
    private RegionMapper regionMapper;

    public RegionServiceImpl(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @Override
    public List<Region> getRegions(Long parentId, Integer level) {
        return regionMapper.selectByParentIdAndLevel(parentId, level);
    }
}