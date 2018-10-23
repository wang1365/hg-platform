package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.OrderMapper;
import com.xiaochuan.web.dto.OrderDTO;
import com.xiaochuan.web.entity.Goods;
import com.xiaochuan.web.entity.Order;
import com.xiaochuan.web.entity.Person;
import com.xiaochuan.web.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/1 10:55
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PersonService personService;

    @Override
    public int addOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateById(order);
    }

    @Override
    public void deleteOrderById(int id) {
        orderMapper.deleteById(id);
    }

    @Override
    public OrderDTO getOrderById(int orderId) {
        Order order = orderMapper.selectById(orderId);
        return transformOrder(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderMapper.selectList(null);
        List<OrderDTO> orderDTOS = orders.stream().map(order -> transformOrder(order)).collect(Collectors.toList());
        return orderDTOS;
    }

    private OrderDTO transformOrder(Order order) {

        Goods goods = goodsService.getGoodsById(order.getGoodsId());

        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(order, dto);
        dto.setGoodsName(goods.getName());

        Person seller = personService.getPersonById(order.getSellerId());
        Person buyer = personService.getPersonById(order.getBuyerId());
        dto.setSellerName(seller != null ? seller.getName() : "");
        dto.setBuyerName(buyer != null ? buyer.getName() : "");

        return dto;
    }
}