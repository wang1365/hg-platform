package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.HgResponse;
import com.xiaochuan.web.dto.OrderDTO;
import com.xiaochuan.web.entity.Order;
import com.xiaochuan.web.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/order/")
@SuppressWarnings("unused")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("getOrderList")
    HgResponse<List<OrderDTO>> getOrderList() {
        List<OrderDTO> orderDTOS = orderService.getAllOrders();
        return HgResponse.success(orderDTOS);
    }

    @PostMapping("addOrder")
    HgResponse add(@RequestBody Order order) {
        orderService.addOrder(order);
        return HgResponse.success();
    }

    @PostMapping("updateOrder")
    HgResponse updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return HgResponse.success();
    }

    @PostMapping("deleteOrderById")
    HgResponse delete(@RequestParam int id) {
        orderService.deleteOrderById(id);
        return HgResponse.success();
    }
}