package com.example.trangbanhangonline.repository.product;

import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
import com.example.trangbanhangonline.entity.Product;
import com.example.trangbanhangonline.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryEM {
    private final EntityManager entityManager;
    private final ProductMapper productMapper;
    public List<ProductResponseDTO> findCondition(ProductRequestDTO productRequestDTO) {
        List<Product> products;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if (productRequestDTO.getProductName() != null){
            predicates.add(cb.like(root.get("productName"), "%" + productRequestDTO.getProductName()+"%"));
        }
        if (productRequestDTO.getProductTypeName() != null){
            predicates.add(cb.like(root.get("productType").get("productTypeName"), "%" + productRequestDTO.getProductTypeName()+"%"));
        }
        if (productRequestDTO.getMinPrice() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), productRequestDTO.getMinPrice()));
        }
        if (productRequestDTO.getMaxPrice() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), productRequestDTO.getMaxPrice()));
        }

        TypedQuery<Product> query = entityManager.createQuery(cq.select(root).distinct(true)
                .where(cb.and(predicates.toArray(new Predicate[]{}))));

        products = query.getResultList();

        return productMapper.toResponseProductList(products);
    }
}
