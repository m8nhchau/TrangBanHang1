package com.example.trangbanhangonline.mapper.shoppingCart;

import com.example.trangbanhangonline.dto.requestDTO.shoppingCart.ShoppingCartRequestDTO;
import com.example.trangbanhangonline.entity.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartRequestMapper {

    ShoppingCart toEntityShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO);

    List<ShoppingCart> toEntityShoppingCartList(List<ShoppingCartRequestDTO> shoppingCartRequestDTOList);
}
