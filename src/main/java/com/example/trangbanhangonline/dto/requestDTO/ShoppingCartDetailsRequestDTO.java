package com.example.trangbanhangonline.dto.requestDTO;

import com.example.trangbanhangonline.entity.ShoppingCart;
import lombok.Data;

@Data
public class ShoppingCartDetailsRequestDTO {
    private Integer cartDetailId;
    private Integer quantity;
    private String shopName;
    private Double totalPrice;
    private Integer productId;
    private ShoppingCart shoppingCart;
}
