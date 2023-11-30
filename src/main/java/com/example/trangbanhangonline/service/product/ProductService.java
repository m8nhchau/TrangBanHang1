package com.example.trangbanhangonline.service.product;

import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;

import java.util.List;


public interface ProductService {

    List<ProductResponseDTO> findByProduct(ProductRequestDTO productRequestDTO);

}
