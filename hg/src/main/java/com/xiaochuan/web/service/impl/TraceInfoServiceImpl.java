package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.dto.OrderDTO;
import com.xiaochuan.web.dto.PlantDTO;
import com.xiaochuan.web.dto.PlantItemDTO;
import com.xiaochuan.web.dto.TraceInfoDTO;
import com.xiaochuan.web.service.OrderService;
import com.xiaochuan.web.service.PlantItemService;
import com.xiaochuan.web.service.PlantService;
import com.xiaochuan.web.service.TraceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/8 10:56
 * @description:
 */
@Service
@Slf4j
public class TraceInfoServiceImpl implements TraceInfoService {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantItemService plantItemService;

    @Override
    public TraceInfoDTO getTraceInfoByOrder(int orderId) {
        TraceInfoDTO traceInfoDTO = new TraceInfoDTO();
        try {
            OrderDTO orderDTO = orderService.getOrderById(orderId);
            traceInfoDTO.setOrderId(orderId);
            traceInfoDTO.setOrderDTO(orderDTO);
            if (orderDTO != null) {
                PlantDTO plantDTO = plantService.getPlantById(orderDTO.getPlantId());
                List<PlantItemDTO> plantItemDTOList = plantItemService.getPlantItemByPlantId(orderDTO.getPlantId());
                traceInfoDTO.setPlantDTO(plantDTO);
                traceInfoDTO.setPlantItemDTOList(plantItemDTOList);
            }
        } catch (Exception e) {
            log.error("Get trace info failed: {}", e);
        }

        return traceInfoDTO;
    }
}