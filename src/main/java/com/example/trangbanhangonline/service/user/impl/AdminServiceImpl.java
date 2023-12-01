package com.example.trangbanhangonline.service.user.impl;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.user.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.user.UserResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.Product;
import com.example.trangbanhangonline.entity.ProductType;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.enums.OrderStatusEnum;
import com.example.trangbanhangonline.mapper.order.OrderMapper;
import com.example.trangbanhangonline.mapper.product.ProductMapper;
import com.example.trangbanhangonline.mapper.product.ProductRequestMapper;
import com.example.trangbanhangonline.mapper.user.UserMapper;
import com.example.trangbanhangonline.repository.order.OrderRepository;
import com.example.trangbanhangonline.repository.product.ProductRepository;
import com.example.trangbanhangonline.repository.product.ProductTypeRepository;
import com.example.trangbanhangonline.repository.user.UserRepository;
import com.example.trangbanhangonline.service.user.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductRequestMapper productRequestMapper;
    private final ProductTypeRepository productTypeRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    //Admin thêm sửa xóa Product
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {

        Product productNew = productRequestMapper.toEntityProduct(productRequestDTO);

        Optional<Product> product = productRepository.findByProductId(productRequestDTO.getProductId());
        if (!product.isPresent()) {
            throw new RuntimeException(" ProductId đa tồn tại!");
        }

        ProductType productType = productTypeRepository.findByProductTypeId(productRequestDTO.getProductTypeId());
        if (productType == null) {
            throw new RuntimeException(" ProductTypeId chưa tồn tại!");
        }
        productNew.setProductType(productType);

        productNew = productRepository.save(productNew);
        ProductResponseDTO productResponseDTO = productMapper.toResponseProduct(productNew);
        return productResponseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product updateProduct(ProductRequestDTO productRequestDTO) {

        Product products = new Product();
        Product product = productRepository.findById(productRequestDTO.getProductId()).orElse(null);

        if (product == null) {
            throw new RuntimeException("Không tìm thấy sản phẩm");
        }
        if (productRequestDTO.getProductId() != null) {
            product.setProductName(productRequestDTO.getProductName());
        }
        if (productRequestDTO.getCreateDate() != null) {
            products.setCreateDate(productRequestDTO.getCreateDate());
        }

        products = productRepository.save(products);
        return products;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product deleteProduct(ProductRequestDTO productRequestDTO) {

        Product product = productRepository.findById(productRequestDTO.getProductId()).orElse(null);

        if (product == null) {
            throw new RuntimeException("Không tìm thấy sản phẩm");
        }
        if (productRequestDTO.getProductId() != null) {
            productRepository.deleteById(product.getProductId());
        }

        product = productRepository.save(product);
        return product;
    }

    //Admin thêm sửa xóa User
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User userNew = userMapper.toEntityUser(userRequestDTO);
        List<User> userList = userRepository.findUserByUserId(userRequestDTO.getUserId());
        if (!userList.isEmpty()) {
            throw new RuntimeException("người dùng không tồn tại");
        }

        userNew = userRepository.save(userNew);
        UserResponseDTO userResponseDTO = userMapper.toResponseUser(userNew);
        return userResponseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {

        User user = userRepository.findById(userRequestDTO.getUserId()).orElse(null);

        if (user == null) {
            throw new RuntimeException("Không tìm thấy nguoi dung");
        }
        if (userRequestDTO.getUserName() != null) {
            user.setUserName(userRequestDTO.getUserName());
        }
        if (userRequestDTO.getBirthday() != null) {
            user.setBirthday(userRequestDTO.getBirthday());
        }

        user = userRepository.save(user);
        UserResponseDTO userResponseDTO = userMapper.toResponseUser(user);
        return userResponseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponseDTO deleteUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(userRequestDTO.getUserId()).orElse(null);

        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng");
        }
        if (userRequestDTO.getUserId() != null) {

        }
        productRepository.deleteById(user.getUserId());
        user = userRepository.save(user);
        UserResponseDTO userResponseDTO = userMapper.toResponseUser(user);
        return userResponseDTO;
    }

    // admin xác nhận/ hủy đơn hàng
    @Override
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {
        Orders orders = orderRepository.findByOrderId(orderRequestDTO.getOrderId());
        if (orders == null) {
            throw new RuntimeException("Đơn hàng đã bị user hủy!");
        }
        if (orders.getStatus().equals(OrderStatusEnum.ChoXacNhan)) {

        }
        if (orderRequestDTO.getOrderId() != null) {

        }
        orders.setStatus(OrderStatusEnum.DaXacNhan);
        orders = orderRepository.save(orders);
        OrderResponseDTO orderResponseDTO = orderMapper.toResponseOrder(orders);
        return  orderResponseDTO;
    }



    @Override
    public OrderResponseDTO cancelOrder(OrderRequestDTO orderRequestDTO) {
        Orders orderDetail = orderRepository.findByOrderId(orderRequestDTO.getOrderId());
        if(orderDetail == null){
            throw new RuntimeException("Đơn hàng đã bị user hủy!");
        }
        if(orderDetail.getStatus().equals(OrderStatusEnum.ChoXacNhan)){

        }
        if(orderDetail.getStatus().equals(OrderStatusEnum.DaXacNhan)){

        }
        if (orderRequestDTO.getOrderId() != null){

        }
        orderDetail.setStatus(OrderStatusEnum.HuyDatHang);
        orderDetail = orderRepository.save(orderDetail);
        OrderResponseDTO orderResponseDTO = orderMapper.toResponseOrder(orderDetail);
        return orderResponseDTO;
    }
}

