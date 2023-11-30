package com.example.trangbanhangonline.dto.requestDTO.order;

import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.Product;
import lombok.Data;

@Data
public class OrderDetailsRequestDTO {
    private Integer orderDetailsId;
    private Integer quantityOrders;
    private Double priceDetails;
    private Integer productId;
    private Orders orders;
}
