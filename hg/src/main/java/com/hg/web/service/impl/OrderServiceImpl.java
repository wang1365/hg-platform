package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.dto.OrderDTO;
import com.hg.web.entity.Area;
import com.hg.web.entity.Goods;
import com.hg.web.entity.User;
import com.hg.web.repository.AreaMapper;
import com.hg.web.repository.GoodsMapper;
import com.hg.web.repository.OrderMapper;
import com.hg.web.entity.Order;
import com.hg.web.repository.UserMapper;
import com.hg.web.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/1 10:55
 * @description:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<OrderDTO> getOrderDTOList() {
        List<Order> orders = this.list(null);

        List<OrderDTO> dtos = orders.stream().map(order-> {
            OrderDTO dto = new OrderDTO();
            BeanUtils.copyProperties(order, dto);

            Area area = areaMapper.selectById(order.getAreaId());
            Goods goods = goodsMapper.selectById(order.getGoodsId());
            dto.setAreaName(area.getName());
            dto.setGoodsName(goods.getName());

            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }
}