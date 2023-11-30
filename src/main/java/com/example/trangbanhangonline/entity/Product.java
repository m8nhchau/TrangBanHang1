package com.example.trangbanhangonline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID", referencedColumnName = "PRODUCT_TYPE_ID")
    private ProductType productType;

}