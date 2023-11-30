package com.example.trangbanhangonline.entity;

import com.example.trangbanhangonline.dto.requestDTO.OrderRequestDTO;
import com.example.trangbanhangonline.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="orders")
public class Orders  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "PRICE")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private OrderStatusEnum status;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
