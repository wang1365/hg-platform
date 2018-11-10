package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.entity.GoodsInbound;
import com.hg.web.repository.GoodsInboundMapper;
import com.hg.web.service.GoodsInboundService;
import org.springframework.stereotype.Service;

@Service
public class GoodsInboundServiceImpl extends ServiceImpl<GoodsInboundMapper, GoodsInbound> implements
    GoodsInboundService {

}
