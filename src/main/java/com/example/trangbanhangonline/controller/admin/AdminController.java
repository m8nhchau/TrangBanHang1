package com.example.trangbanhangonline.controller.admin;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.user.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.user.UserResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.Product;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.enums.UserRoleEnum;
import com.example.trangbanhangonline.service.user.AdminService;
import com.example.trangbanhangonline.service.session.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;
    private final SessionService sessionService;
//Them sua xoa Product
    @PostMapping("/create-product")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestHeader(name = "SESSION_CODE") String sessionCode,@RequestBody ProductRequestDTO productRequestDTO) {
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        ProductResponseDTO createProduct = adminService.addProduct(productRequestDTO);
        return ResponseEntity.ok(createProduct);
    }

    @PostMapping("/delete-product")
    public ResponseEntity<Product> deleteProduct(@RequestHeader(name = "SESSION_CODE") String sessionCode,@RequestBody ProductRequestDTO productRequestDTO) {
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        Product removeProduct = adminService.deleteProduct(productRequestDTO);
        return ResponseEntity.ok(removeProduct);
    }

    @PutMapping("/update-product")
    public ResponseEntity<Product> updateProduct(@RequestHeader(name = "SESSION_CODE") String sessionCode,@RequestBody ProductRequestDTO productRequestDTO) {
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        Product addProduct = adminService.updateProduct(productRequestDTO);
        return ResponseEntity.ok(addProduct);
    }

// them sua xoa User
    @PostMapping("/create-user")
    public ResponseEntity<UserResponseDTO> addUser(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody UserRequestDTO userRequestDTO){
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        UserResponseDTO createUser = adminService.addUser(userRequestDTO);
        return ResponseEntity.ok(createUser);
    }

    @PutMapping("/update-user")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestHeader(name = "SESSION_CODE") String sessionCode,@RequestBody UserRequestDTO userRequestDTO){
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        UserResponseDTO addUser = adminService.updateUser(userRequestDTO);
        return ResponseEntity.ok(addUser);
    }

    @PostMapping("/delete-user")
    public ResponseEntity<UserResponseDTO> deleteUser(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody UserRequestDTO userRequestDTO) {
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        UserResponseDTO removeUser = adminService.deleteUser(userRequestDTO);
        return ResponseEntity.ok(removeUser);
    }
    @PostMapping("/find-user")
    public ResponseEntity<List<UserResponseDTO>> findUser(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody UserRequestDTO userRequestDTO){
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        List<UserResponseDTO> findUser = adminService.findByUser(userRequestDTO);
        return ResponseEntity.ok(findUser);
    }
    //admin xac nhan/huy don hang
    @PostMapping("/access-order")
    public ResponseEntity<OrderResponseDTO> updateOrder(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody OrderRequestDTO orderRequestDTO){
        User currentUser = sessionService.validate(sessionCode);
        if(!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)){
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        OrderResponseDTO addOrder = adminService.addOrder(orderRequestDTO);
    return ResponseEntity.ok(addOrder);
    }

    @PostMapping("/cancel-order")
    public ResponseEntity<OrderResponseDTO> cancelOrder(@RequestHeader(name = "SESSION_CODE") String sessionCode, @RequestBody OrderRequestDTO orderRequestDTO) {
        User currentUser = sessionService.validate(sessionCode);
        if (!currentUser.getUserRole().equals(UserRoleEnum.ADMIN)) {
            throw new RuntimeException("Bạn không có quyền truy nhập!");
        }
        OrderResponseDTO cancelOrder = adminService.cancelOrder(orderRequestDTO);
        return ResponseEntity.ok(cancelOrder);
    }
}
