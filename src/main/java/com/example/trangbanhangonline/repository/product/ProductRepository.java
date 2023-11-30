package com.example.trangbanhangonline.repository.product;

import com.example.trangbanhangonline.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByProductId(Integer productId);
}
