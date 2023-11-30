package com.example.trangbanhangonline.service.product.Impl;

import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
import com.example.trangbanhangonline.repository.product.ProductRepositoryEM;
import com.example.trangbanhangonline.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepositoryEM productRepositoryEM;

    @Override
    public List<ProductResponseDTO> findByProduct(ProductRequestDTO productRequestDTO) {
        List<ProductResponseDTO> productResponseDTOS = productRepositoryEM.findCondition(productRequestDTO);
        return productResponseDTOS;
    }
}
