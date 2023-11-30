package com.example.trangbanhangonline.mapper.shoppingCart;

import com.example.trangbanhangonline.dto.responseDTO.shoppingCart.ShoppingCartResponseDTO;
import com.example.trangbanhangonline.entity.ShoppingCart;
import com.example.trangbanhangonline.mapper.shoppingCart.ShoppingCartDetailsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring", uses = {ShoppingCartDetailsMapper.class})
public interface ShoppingCartMapper {

    @Mapping(source = "shoppingCartDetails", target = "shoppingCartDetails", qualifiedByName = "toResponseShoppingCartDetailsList")
    ShoppingCartResponseDTO toResponseShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCartResponseDTO> toResponseShoppingCartList(List<ShoppingCart> shoppingCartList);

}
