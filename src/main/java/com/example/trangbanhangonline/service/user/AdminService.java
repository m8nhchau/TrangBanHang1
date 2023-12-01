package com.example.trangbanhangonline.service.user;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.user.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.user.UserResponseDTO;
import com.example.trangbanhangonline.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AdminService {
// thêm sửa xóa product
    Product updateProduct(ProductRequestDTO productRequestDTO);
    Product deleteProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
// thêm sửa xóa user
    UserResponseDTO addUser(UserRequestDTO userRequestDTO);
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
    UserResponseDTO deleteUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> findByUser(UserRequestDTO userRequestDTO);
// xác nhận/ hủy dơn hàng

    OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);
    OrderResponseDTO cancelOrder(OrderRequestDTO orderRequestDTO);
}
