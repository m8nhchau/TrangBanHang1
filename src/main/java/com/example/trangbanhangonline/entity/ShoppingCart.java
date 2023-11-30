package com.example.trangbanhangonline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name ="shoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Integer cartId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @JsonBackReference
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<ShoppingCartDetails> shoppingCartDetails;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
