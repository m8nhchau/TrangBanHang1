package com.example.trangbanhangonline.repository.order;

import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
 List<Orders> findByUser(User user);
 List<Orders> findByUser_UserId(Integer userId);
 Orders findByOrderId(Integer orderId);
}
