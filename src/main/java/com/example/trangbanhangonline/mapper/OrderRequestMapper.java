package com.example.trangbanhangonline.mapper;

import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.entity.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper {
    Orders toEntityOrders(OrderRequestDTO orderRequestDTO);
}
