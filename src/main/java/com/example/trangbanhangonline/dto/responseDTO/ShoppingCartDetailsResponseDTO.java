package com.example.trangbanhangonline.dto.responseDTO;

import com.example.trangbanhangonline.entity.Product;
import com.example.trangbanhangonline.entity.ShoppingCart;
import lombok.Data;

@Data
public class ShoppingCartDetailsResponseDTO {
    private Integer cartDetailId;
    private Integer quantity;
    private String shopName;
    private Double totalPrice;
    private ShoppingCartResponseDTO shoppingCart;
    private ProductResponseDTO product;
}
