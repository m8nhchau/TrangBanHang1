//package com.example.trangbanhangonline.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "customer")
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CUSTOMER_ID")
//    private Integer custId;
//
//    @Column(name = "USER_NAME")
//    private String userName;
//
//    @Column(name = "PASSWORD")
//    private String password;
//
//    @OneToOne
//    @JsonBackReference
//    @JoinColumn(name = "USER_ID")
//    private Users users;
//
//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "ORDER_ID")
//    private Order order;
//
//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
//    List<Products> productsList;
//}
