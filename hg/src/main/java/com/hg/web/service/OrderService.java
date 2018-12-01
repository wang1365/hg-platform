package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.OrderDTO;
import com.hg.web.entity.Order;

import java.util.List;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/1 10:55
 * @description:
 */
public interface OrderService extends IService<Order> {
    List<OrderDTO> getOrderDTOList();
}
