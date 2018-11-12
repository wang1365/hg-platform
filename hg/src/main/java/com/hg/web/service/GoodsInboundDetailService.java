package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsInboundDetailDto;
import com.hg.web.entity.GoodsInboundDetail;
import java.util.List;

public interface GoodsInboundDetailService extends IService<GoodsInboundDetail> {
    List<GoodsInboundDetailDto> listDetailsById(long id);
}
