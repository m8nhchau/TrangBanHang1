package com.example.trangbanhangonline.repository.product;

import com.example.trangbanhangonline.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    ProductType findByProductTypeId(Integer productTypeId);
}
