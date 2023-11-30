package com.example.trangbanhangonline.dto.requestDTO.order;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderDetailsRequestDTO;
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

