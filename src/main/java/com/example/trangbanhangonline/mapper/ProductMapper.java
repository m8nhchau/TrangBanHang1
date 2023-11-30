package com.example.trangbanhangonline.mapper;

import com.example.trangbanhangonline.dto.responseDTO.ProductResponseDTO;
import com.example.trangbanhangonline.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(ignore = true, target = "productType")
    ProductResponseDTO toResponseProduct(Product product);
    List<ProductResponseDTO> toResponseProductList(List<Product> productLists);
}
