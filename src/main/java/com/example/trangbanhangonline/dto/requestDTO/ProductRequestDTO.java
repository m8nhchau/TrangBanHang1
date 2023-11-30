package com.example.trangbanhangonline.dto.requestDTO;

import lombok.Data;

import java.util.Date;


@Data
public class ProductRequestDTO {
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Date createDate;
    private Integer productTypeId;


}
