package com.xiaochuan.web.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaochuan.web.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}