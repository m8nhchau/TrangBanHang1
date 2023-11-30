package com.example.trangbanhangonline.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "productType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_TYPE_ID")
    private Integer productTypeId;

    @Column(name = "PRODUCT_NAME")
    private String productTypeName;

    @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
    List<Product> products;

}

