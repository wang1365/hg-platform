package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsOutboundDetailDto;
import com.hg.web.entity.GoodsOutboundDetail;
import java.util.List;

public interface GoodsOutboundDetailService extends IService<GoodsOutboundDetail> {
    List<GoodsOutboundDetailDto> listDetailsById(long id);
}
