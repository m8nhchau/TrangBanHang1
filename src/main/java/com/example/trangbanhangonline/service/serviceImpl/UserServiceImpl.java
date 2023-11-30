package com.example.trangbanhangonline.service.serviceImpl;

import com.example.trangbanhangonline.Utils.DateUtils;
import com.example.trangbanhangonline.Utils.SessionUtils;
import com.example.trangbanhangonline.dto.requestDTO.LoginDTO;
import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartDetailsRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.OrderResponseDTO;
import com.example.trangbanhangonline.dto.responseDTO.ShoppingCartResponseDTO;
import com.example.trangbanhangonline.entity.*;
import com.example.trangbanhangonline.enums.OrderStatusEnum;
import com.example.trangbanhangonline.mapper.*;
import com.example.trangbanhangonline.repository.*;
import com.example.trangbanhangonline.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartDetailsRepository shoppingCartDetailsRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderRequestMapper orderRequestMapper;


    @Value("${secret.key}")
    private String secretKey;

    //login
    @Override
    public boolean checkPasswordUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user.getPassword().equals(password)) return true;
        return false;
    }

    @Override
    public boolean checkUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) return false;
        return true;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String login(LoginDTO loginDTO) throws NoSuchAlgorithmException {

        Optional<User> user = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (!user.isPresent()) {
            throw new RuntimeException("Sai email or password");
        }
        String sessionCode = SessionUtils.getInstance().generateSession(new Date().getTime() + "");
        Session session = sessionRepository.findByUser_UserId(user.get().getUserId()).orElse(new Session());
        session.setSessionCode(sessionCode);
        session.setUser(user.get());
        session.setExpiredDate(DateUtils.addMinute(new Date(), 360));
        sessionRepository.save(session);
        return sessionCode;
    }

    // thêm sửa xóa giỏ hàng
    @Override
    public ShoppingCartResponseDTO updateShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO, User currentUser) {

        //ShoppingCart shoppingCart = shoppingCartRepository.findByUser_UserId(currentUser.getUserId());
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(currentUser);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(currentUser);
            shoppingCartRepository.save(shoppingCart);
        }
        List<ShoppingCartDetails> shoppingCartDetailsList = shoppingCartDetailsRepository.findByShoppingCart_cartId(shoppingCart.getCartId());
        shoppingCartDetailsRepository.deleteAll(shoppingCartDetailsList);

        List<ShoppingCartDetails> shoppingCartDetailsNew = new ArrayList<>();
        if (shoppingCartRequestDTO.getShoppingCartDetailsRequestDTOS() != null) {
            ShoppingCart finalShoppingCart = shoppingCart;
            shoppingCartRequestDTO.getShoppingCartDetailsRequestDTOS().forEach(cardDetail -> {
                handleCardDetailException(cardDetail);
                Product product = productRepository.findByProductId(cardDetail.getProductId()).orElse(null);
                if (product == null) {
                    throw new RuntimeException("San pham khong ton tai!");
                }
                ShoppingCartDetails shoppingCartDetails = new ShoppingCartDetails();
                shoppingCartDetails.setShoppingCart(finalShoppingCart);
                shoppingCartDetails.setProduct(product);
                shoppingCartDetails.setQuantity(cardDetail.getQuantity());

                shoppingCartDetailsNew.add(shoppingCartDetails);
            });
        }
        shoppingCart.setShoppingCartDetails(shoppingCartDetailsNew);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.toResponseShoppingCart(shoppingCart);
    }

    @Override
    public ShoppingCartResponseDTO getShoppingCart(User currentUser) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(currentUser);
        return shoppingCartMapper.toResponseShoppingCart(shoppingCart);
    }

    // tạo đơn đặt hàng
    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO, User currentUser) {
        Orders orderNew = new Orders();
        orderNew.setUser(currentUser);
        orderNew.setOrderDate(new Date());
        orderNew.setStatus(OrderStatusEnum.ChoXacNhan);
        List<OrderDetails> orderDetailNews = new ArrayList<>();
        if(orderRequestDTO.getOrderDetails() == null || orderRequestDTO.getOrderDetails().isEmpty()){
            throw new RuntimeException("Don hang trong them san pham!");
        }
            orderRequestDTO.getOrderDetails().forEach(orderDetail -> {
                Product product = productRepository.findByProductId(orderDetail.getProductId()).orElse(null);
                if (product == null) {
                    throw new RuntimeException("San pham khong ton tai!");
                }
                if (orderDetail.getQuantityOrders() == null || orderDetail.getQuantityOrders() < 1 || orderDetail.getQuantityOrders() > product.getQuantity() ){
                   throw new RuntimeException("so luong san pham khong hop le!");
                }
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setPriceDetails(product.getPrice());
                orderDetails.setOrders(orderNew);
                orderDetails.setProduct(product);
                orderDetails.setQuantityOrders(orderDetail.getQuantityOrders());
                orderDetailNews.add(orderDetails);
            });

        orderNew.setOrderDetails(orderDetailNews);
        orderRepository.save(orderNew);
        return orderMapper.toResponseOrder(orderNew);
    }

    @Override
    public List<OrderResponseDTO> getOrder(User nowUser) {
        List<Orders> orders = orderRepository.findByUser(nowUser);
        List<OrderResponseDTO> orderResponseDTOS = new ArrayList<>();
        orders.forEach(order -> {
            OrderResponseDTO orderResponseDTO = orderMapper.toResponseOrder(order);
            orderResponseDTOS.add(orderResponseDTO);
        });
        return orderResponseDTOS;
    }

    @Override
    public OrderResponseDTO deleteOrder(OrderRequestDTO orderRequestDTO, User nowUser) {
        Orders orderDetail = orderRepository.findByOrderId(orderRequestDTO.getOrderId());
        if(orderDetail == null){
            throw new RuntimeException("Đơn hàng không tồn tại!");
        }
        if(orderDetail.getStatus().equals(OrderStatusEnum.ChoXacNhan)){

        }
        if(orderDetail.getStatus().equals(OrderStatusEnum.DaXacNhan)){
            throw new RuntimeException("Đơn hàng đã xác nhận không thể hủy");
        }
        if (orderRequestDTO.getOrderId() != null){

        }
        orderDetail.setStatus(OrderStatusEnum.HuyDatHang);
        orderDetail = orderRepository.save(orderDetail);
        OrderResponseDTO orderResponseDTO = orderMapper.toResponseOrder(orderDetail);
        return orderResponseDTO;
    }

    private void handleCardDetailException(ShoppingCartDetailsRequestDTO cardDetail) {
        if(cardDetail.getProductId() == null){
            throw new RuntimeException("productId khong duoc de trong!");
        }
        if(cardDetail.getQuantity() == null){
            throw new RuntimeException("Them so luong san pham!");
        }
        if(cardDetail.getQuantity() < 1){
            throw new RuntimeException("So luong san pham khong dat yeu cau!");
        }
    }

}