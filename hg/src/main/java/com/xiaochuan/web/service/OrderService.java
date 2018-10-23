package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.OrderDTO;
import com.xiaochuan.web.entity.Order;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/1 10:55
 * @description:
 */
public interface OrderService {
    int addOrder(Order order);
    int updateOrder(Order order);
    void deleteOrderById(int orderId);
    OrderDTO getOrderById(int orderId);
    List<OrderDTO> getAllOrders();
}
