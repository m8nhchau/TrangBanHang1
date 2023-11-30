package com.example.trangbanhangonline.mapper.shoppingCart;

import com.example.trangbanhangonline.dto.responseDTO.shoppingCart.ShoppingCartDetailsResponseDTO;
import com.example.trangbanhangonline.entity.ShoppingCartDetails;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartDetailsMapper {

    @Named("toResponseShoppingCartDetails")
    @Mapping(source = "shoppingCart", target = "shoppingCart", ignore = true)
    ShoppingCartDetailsResponseDTO toResponseShoppingCartDetails(ShoppingCartDetails shoppingCartDetails);

    @Named("toResponseShoppingCartDetailsList")
    @IterableMapping(qualifiedByName = "toResponseShoppingCartDetails")
    List<ShoppingCartDetailsResponseDTO> toResponseShoppingCartDetailsList(List<ShoppingCartDetails> shoppingCartDetailsList);

}
