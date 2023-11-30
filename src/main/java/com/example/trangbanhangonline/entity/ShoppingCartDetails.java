package com.example.trangbanhangonline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "shoppingCartDetails")
public class ShoppingCartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_DETAIL_ID")
    private Integer cartDetailId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SHOP_NAME")
    private String shopName;

    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "CART_ID")
    private ShoppingCart shoppingCart;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;
}

