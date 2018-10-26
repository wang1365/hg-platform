package com.hg.web.service.impl;

import com.hg.web.repository.RegionMapper;
import com.hg.web.entity.Region;
import com.hg.web.service.RegionSersvice;
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