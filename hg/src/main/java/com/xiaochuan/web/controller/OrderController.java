package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
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
    TraceResponse<List<OrderDTO>> getOrderList() {
        List<OrderDTO> orderDTOS = orderService.getAllOrders();
        return TraceResponse.success(orderDTOS);
    }

    @PostMapping("addOrder")
    TraceResponse add(@RequestBody Order order) {
        orderService.addOrder(order);
        return TraceResponse.success();
    }

    @PostMapping("updateOrder")
    TraceResponse updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return TraceResponse.success();
    }

    @PostMapping("deleteOrderById")
    TraceResponse delete(@RequestParam int id) {
        orderService.deleteOrderById(id);
        return TraceResponse.success();
    }
}