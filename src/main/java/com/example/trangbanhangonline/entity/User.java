package com.example.trangbanhangonline.entity;

import com.example.trangbanhangonline.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "BIRTH_DAY")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ADDRESS")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private UserRoleEnum userRole;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private Session session;

}
