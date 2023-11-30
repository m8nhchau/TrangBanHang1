package com.example.trangbanhangonline.dto.requestDTO.product;

import lombok.Data;

import java.util.Date;


@Data
public class ProductRequestDTO {
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Integer minPrice;
    private Integer maxPrice;
    private Double price;
    private Date createDate;
    private String productTypeName;
    private Integer productTypeId;


}
