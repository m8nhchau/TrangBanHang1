package com.example.trangbanhangonline.dto.responseDTO.shoppingCart;

import com.example.trangbanhangonline.dto.responseDTO.shoppingCart.ShoppingCartDetailsResponseDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShoppingCartResponseDTO {
    private Integer cartId;
    private Date createDate;
    private List<ShoppingCartDetailsResponseDTO> shoppingCartDetails;
}
