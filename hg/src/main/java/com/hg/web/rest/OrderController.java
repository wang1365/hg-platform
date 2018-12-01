package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.OrderDTO;
import com.hg.web.entity.Order;
import com.hg.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("getOrderList")
    HgResponse<List<OrderDTO>> getOrderList() {
        List<OrderDTO> orders = orderService.getOrderDTOList();
        return HgResponse.success(orders);
    }

    @PostMapping("addOrder")
    HgResponse add(@RequestBody Order order) {
        orderService.save(order);
        return HgResponse.success();
    }

    @PostMapping("updateOrder")
    HgResponse updateOrder(@RequestBody Order order) {
        orderService.updateById(order);
        return HgResponse.success();
    }

    @PostMapping("deleteOrderById")
    HgResponse delete(@RequestParam long id) {
        orderService.removeById(id);
        return HgResponse.success();
    }
}