package com.example.trangbanhangonline.dto.responseDTO.order;

import com.example.trangbanhangonline.entity.OrderDetails;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.enums.OrderStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponseDTO {
    private Integer orderId;
    private Date orderDate;
    private Double price;
    private OrderStatusEnum status;
    private List<OrderDetails> orderDetails;
//    private User user;
}
