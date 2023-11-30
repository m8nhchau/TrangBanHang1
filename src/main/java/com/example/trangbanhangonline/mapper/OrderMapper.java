package com.example.trangbanhangonline.mapper;

import com.example.trangbanhangonline.dto.responseDTO.OrderResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponseDTO toResponseOrder(Orders order);

    List<OrderResponseDTO> toResponseOrderList(List<Orders> orderList);
}