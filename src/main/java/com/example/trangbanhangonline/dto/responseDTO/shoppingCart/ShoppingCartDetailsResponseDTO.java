package com.example.trangbanhangonline.dto.responseDTO.shoppingCart;

import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
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
