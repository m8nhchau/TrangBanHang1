package com.example.trangbanhangonline.repository;

import com.example.trangbanhangonline.entity.ShoppingCart;
import com.example.trangbanhangonline.entity.ShoppingCartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShoppingCartDetailsRepository extends JpaRepository<ShoppingCartDetails, Integer> {
    List<ShoppingCartDetails> findByShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCartDetails> findByShoppingCart_cartId(Integer cardId);


//    List<ShoppingCartDetails> findAllBy(ShoppingCart shoppingCart);
}
