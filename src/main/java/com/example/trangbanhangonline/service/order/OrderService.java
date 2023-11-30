package com.example.trangbanhangonline.service.order;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface OrderService {
    List<OrderResponseDTO> findByOrder(OrderRequestDTO orderRequestDTO) throws ParseException;
}
