package com.example.trangbanhangonline.dto.requestDTO;

import com.example.trangbanhangonline.entity.OrderDetails;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.enums.OrderStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Integer orderId;
    private Date orderDate;
    private Double price;
    private Integer status;
    private List<OrderDetailsRequestDTO> orderDetails;
    private Integer userId;
    private String fullName;
}

