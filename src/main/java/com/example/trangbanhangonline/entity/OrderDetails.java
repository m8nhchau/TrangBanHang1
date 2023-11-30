package com.example.trangbanhangonline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name ="orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_DETAILS_ID")
    private Integer orderDetailsId;

    @Column(name = "QUANTITY_ORDERS")
    private Integer quantityOrders;

    @Column(name = "PRICE_DETAILS")
    private Double priceDetails;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders orders;
}
