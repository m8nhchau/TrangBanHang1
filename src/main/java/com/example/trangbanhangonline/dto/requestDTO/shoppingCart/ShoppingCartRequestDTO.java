package com.example.trangbanhangonline.dto.requestDTO.shoppingCart;

import com.example.trangbanhangonline.dto.requestDTO.shoppingCart.ShoppingCartDetailsRequestDTO;
import com.example.trangbanhangonline.entity.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShoppingCartRequestDTO  {
    private Integer cartId;
    private Date createDate;
    private Integer cartDetailId;
    private List<ShoppingCartDetailsRequestDTO> shoppingCartDetailsRequestDTOS;
    private User user;
}
