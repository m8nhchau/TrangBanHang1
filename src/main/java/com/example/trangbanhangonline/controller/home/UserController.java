package com.example.trangbanhangonline.controller.home;

import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.OrderResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.ShoppingCartResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.enums.UserRoleEnum;
import com.example.trangbanhangonline.service.SessionService;
import com.example.trangbanhangonline.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final SessionService sessionService;

    //them sua xoa gio hang
    @PostMapping("/update-cart")
    public ResponseEntity<ShoppingCartResponseDTO> updateShoppingCart(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
        User nowUser = sessionService.validate(sessionCode);
        if(!UserRoleEnum.USER.equals(nowUser.getUserRole())){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        ShoppingCartResponseDTO updateShoppingCart = userService.updateShoppingCart(shoppingCartRequestDTO, nowUser);
        return ResponseEntity.ok(updateShoppingCart);
    }

    @GetMapping("/cart")
    public ResponseEntity<ShoppingCartResponseDTO> getShoppingCart(@RequestHeader(name = "SESSION_CODE") String sessionCode){
        User nowUser = sessionService.validate(sessionCode);
        if(!UserRoleEnum.USER.equals(nowUser.getUserRole())){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        ShoppingCartResponseDTO showShoppingCart = userService.getShoppingCart(nowUser);
        return  ResponseEntity.ok(showShoppingCart);
    }

    // user them/huy don hang
    @PostMapping("/create-orders")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody OrderRequestDTO orderRequestDTO){
        User nowUser = sessionService.validate(sessionCode);
        if(!UserRoleEnum.USER.equals(nowUser.getUserRole())){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        OrderResponseDTO createOrder = userService.createOrder(orderRequestDTO, nowUser);
        return ResponseEntity.ok(createOrder);
    }
    // User xem don hang
    @GetMapping("/orders")
    private ResponseEntity<List<OrderResponseDTO>> getOrder(@RequestHeader(name = "SESSION_CODE") String sessionCode) {
        User nowUser = sessionService.validate(sessionCode);
        if (!UserRoleEnum.USER.equals(nowUser.getUserRole())) {
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        List<OrderResponseDTO> getOrder = userService.getOrder(nowUser);
        return ResponseEntity.ok(getOrder);
    }
    // User xoa don hang khi chua xac nhan
    @PostMapping("delete-orders")
    private ResponseEntity<OrderResponseDTO> deleteOrder(@RequestHeader( name = "SESSION_CODE") String sessionCode, @RequestBody OrderRequestDTO orderRequestDTO){
        User nowUser = sessionService.validate(sessionCode);
        if(!UserRoleEnum.USER.equals(nowUser.getUserRole())){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        OrderResponseDTO removeOrder = userService.deleteOrder(orderRequestDTO, nowUser);
        return ResponseEntity.ok(removeOrder);
    }
}
