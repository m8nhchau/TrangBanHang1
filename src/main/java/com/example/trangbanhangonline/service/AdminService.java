package com.example.trangbanhangonline.service;

import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ProductRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.ProductResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.UserResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.Product;
import com.example.trangbanhangonline.entity.User;
import org.springframework.stereotype.Service;



@Service
public interface AdminService {
// thêm sửa xóa product
    Product updateProduct(ProductRequestDTO productRequestDTO);
    Product deleteProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
// thêm sửa xóa user
    UserResponseDTO addUser(UserRequestDTO userRequestDTO);
    User updateUser(UserRequestDTO userRequestDTO);
    User deleteUser(UserRequestDTO userRequestDTO);
// xác nhận dơn hàng
    Orders addOrder(OrderRequestDTO orderRequestDTO);
}
