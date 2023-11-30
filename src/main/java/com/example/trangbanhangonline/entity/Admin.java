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
//@Table(name = "admin")
//public class Admin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ADMIN_ID")
//    private Integer adminId;
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
//}