package com.example.trangbanhangonline.service;

import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.OrderResponseDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface OrderService {
    List<OrderResponseDTO> findByOrder(OrderRequestDTO orderRequestDTO) throws ParseException;
}
