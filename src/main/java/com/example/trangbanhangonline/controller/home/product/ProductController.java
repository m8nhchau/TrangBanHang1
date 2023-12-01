package com.example.trangbanhangonline.controller.home.product;

import com.example.trangbanhangonline.dto.requestDTO.product.ProductRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.product.ProductResponseDTO;
import com.example.trangbanhangonline.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/find-product")
    public ResponseEntity<List<ProductResponseDTO>> getProduct(@RequestBody ProductRequestDTO productRequestDTO){
        List<ProductResponseDTO> findProduct = productService.findByProduct(productRequestDTO);
        return ResponseEntity.ok(findProduct);

    }
}
