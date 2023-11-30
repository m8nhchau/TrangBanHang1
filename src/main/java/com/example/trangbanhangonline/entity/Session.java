package com.example.trangbanhangonline.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SESSION_ID")
    private Integer sessionId;

    @Column(name = "SESSION_CODE", unique = true)
    private String sessionCode;

    @Column(name = "EXPIRED_DATE")
    private Date expiredDate;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "USER_ID")
    private User user;

}
