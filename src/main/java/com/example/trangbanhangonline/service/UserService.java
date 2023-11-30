package com.example.trangbanhangonline.service;

import com.example.trangbanhangonline.dto.requestDTO.LoginDTO;
import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.OrderResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.ShoppingCartResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface UserService {
    //login
    boolean checkUserByEmail(String email);

    boolean checkPasswordUser(String email, String password);

    User getUserByEmail(String email);

    String login(LoginDTO loginDTO) throws NoSuchAlgorithmException;

    //thêm sửa xóa giỏ hàng
    ShoppingCartResponseDTO updateShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO, User user);
    //xem giỏ hàng
    ShoppingCartResponseDTO getShoppingCart( User user);
    // tạo đơn đặt hàng
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO, User user);

    List<OrderResponseDTO> getOrder(User nowUser);

    OrderResponseDTO deleteOrder(OrderRequestDTO orderRequestDTO, User nowUser);
}