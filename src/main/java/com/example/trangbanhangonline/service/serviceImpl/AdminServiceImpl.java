package com.example.trangbanhangonline.service.serviceImpl;

import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ProductRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.ProductResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.UserResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.Product;
import com.example.trangbanhangonline.entity.ProductType;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.mapper.ProductMapper;
import com.example.trangbanhangonline.mapper.ProductRequestMapper;
import com.example.trangbanhangonline.mapper.UserMapper;
import com.example.trangbanhangonline.repository.ProductRepository;
import com.example.trangbanhangonline.repository.ProductTypeRepository;
import com.example.trangbanhangonline.repository.UserRepository;
import com.example.trangbanhangonline.service.AdminService;
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
        if(!userList.isEmpty()) {
            throw new RuntimeException("người dùng không tồn tại");
        }

        userNew = userRepository.save(userNew);
        UserResponseDTO userResponseDTO = userMapper.toResponseUser(userNew);
        return userResponseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(UserRequestDTO userRequestDTO) {

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
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User deleteUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(userRequestDTO.getUserId()).orElse(null);

        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng");
        }
        if (userRequestDTO.getUserId() != null) {
            productRepository.deleteById(user.getUserId());
        }

        user = userRepository.save(user);
        return user;
    }

    @Override
    public Orders addOrder(OrderRequestDTO orderRequestDTO) {
        return null;
    }

}
