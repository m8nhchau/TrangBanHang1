package com.example.trangbanhangonline.mapper.order;

import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponseDTO toResponseOrder(Orders order);

    List<OrderResponseDTO> toResponseOrderList(List<Orders> orderList);
}