package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.entity.Area;
import com.hg.web.repository.AreaMapper;
import com.hg.web.service.AreaService;
import org.springframework.stereotype.Service;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

}
