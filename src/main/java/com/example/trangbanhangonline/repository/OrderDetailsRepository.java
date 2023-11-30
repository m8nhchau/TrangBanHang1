package com.example.trangbanhangonline.repository;

import com.example.trangbanhangonline.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> findByOrders_orderId(Integer orderId);
}
