package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsDTO;
import com.hg.web.entity.Goods;

import java.util.List;


/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface GoodsService extends IService<Goods> {
    List<GoodsDTO> listGoodsDetail();
    Goods selectByBarCode(String barCode);
}
