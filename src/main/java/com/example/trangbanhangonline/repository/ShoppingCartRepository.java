package com.example.trangbanhangonline.repository;

import com.example.trangbanhangonline.entity.ShoppingCart;
import com.example.trangbanhangonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    ShoppingCart findByCartId(Integer cartId);

    ShoppingCart findByUser_UserId(Integer userId);

    ShoppingCart findByUser(User user);
}
