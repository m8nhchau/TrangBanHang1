package com.example.trangbanhangonline.mapper;

import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartRequestDTO;
import com.example.trangbanhangonline.entity.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartRequestMapper {

    ShoppingCart toEntityShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO);

    List<ShoppingCart> toEntityShoppingCartList(List<ShoppingCartRequestDTO> shoppingCartRequestDTOList);
}
