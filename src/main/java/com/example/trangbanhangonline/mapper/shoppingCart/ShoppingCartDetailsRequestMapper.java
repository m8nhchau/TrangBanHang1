package com.example.trangbanhangonline.mapper.shoppingCart;

import com.example.trangbanhangonline.dto.requestDTO.shoppingCart.ShoppingCartDetailsRequestDTO;
import com.example.trangbanhangonline.entity.ShoppingCartDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartDetailsRequestMapper {
    ShoppingCartDetails toEntityShoppingCartDetails(ShoppingCartDetailsRequestDTO shoppingCartDetailsRequestDTO);

    List<ShoppingCartDetails> toEntityShoppingCartDetailsList(List<ShoppingCartDetailsRequestDTO> shoppingCartDetailsRequestDTOList);
}
