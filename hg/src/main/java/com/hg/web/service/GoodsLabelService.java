package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.GoodsLabelDTO;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsLabel;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:51
 * @description:
 */
public interface GoodsLabelService extends IService<GoodsLabel> {
    List<GoodsLabelDTO> listDetail();
}
