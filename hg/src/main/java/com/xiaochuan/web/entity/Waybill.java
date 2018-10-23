package com.xiaochuan.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author Rongjun Gao
 * @version 1.0.0
 * @date 2018/9/21 16:28
 */
@Data
public class Waybill {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private String driverName;
    private String driverPhone;
    // 车牌号
    private String plateNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GTM+8")
    private String startTime;
    private String startLocation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GTM+8")
    private String endTime;
    private String endLocation;

    // 订单ID
    private Integer orderId;

}
