package com.example.trangbanhangonline.mapper.product;

import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    Product toEntityProduct(ProductRequestDTO productRequestDTO);

    List<Product> toEntityProductList(List<ProductRequestDTO> productRequestDTOList);
}
