package com.example.trangbanhangonline.dto.responseDTO;

import com.example.trangbanhangonline.entity.ProductType;
import lombok.Data;

import java.util.Date;

@Data
public class ProductResponseDTO {
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Date createDate;
    private ProductType productType;
}
