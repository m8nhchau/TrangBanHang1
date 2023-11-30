package com.example.trangbanhangonline.mapper;

import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartDetailsRequestDTO;
import com.example.trangbanhangonline.dto.requestDTO.ShoppingCartRequestDTO;
import com.example.trangbanhangonline.entity.ShoppingCart;
import com.example.trangbanhangonline.entity.ShoppingCartDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartDetailsRequestMapper {
    ShoppingCartDetails toEntityShoppingCartDetails(ShoppingCartDetailsRequestDTO shoppingCartDetailsRequestDTO);

    List<ShoppingCartDetails> toEntityShoppingCartDetailsList(List<ShoppingCartDetailsRequestDTO> shoppingCartDetailsRequestDTOList);
}
