package com.example.trangbanhangonline.controller.home.order;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.enums.UserRoleEnum;
import com.example.trangbanhangonline.service.order.OrderService;
import com.example.trangbanhangonline.service.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final SessionService sessionService;

    @GetMapping("/order-filter")
    public ResponseEntity<List<OrderResponseDTO>> findOrder(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody OrderRequestDTO orderRequestDTO) throws ParseException {
        User currentUser = sessionService.validate(sessionCode);
        if (!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)) {
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        List<OrderResponseDTO> findOrder = orderService.findByOrder(orderRequestDTO);
        return ResponseEntity.ok(findOrder);
    }
}
