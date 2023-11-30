package com.example.trangbanhangonline.service.order.impl;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.repository.order.OrderRepositoryEM;
import com.example.trangbanhangonline.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepositoryEM orderRepositoryEM;
    @Override
    public List<OrderResponseDTO> findByOrder(OrderRequestDTO orderRequestDTO) throws ParseException {
        List<OrderResponseDTO> orderResponseDTOS = orderRepositoryEM.findCondition(orderRequestDTO);
        return orderResponseDTOS;
    }
}
