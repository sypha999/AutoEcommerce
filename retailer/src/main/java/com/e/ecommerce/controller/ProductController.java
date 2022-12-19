package com.e.ecommerce.controller;

import com.e.ecommerce.DTOs.ProductDTO;
import com.e.ecommerce.service.serviceImplementation.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("create_product")
    public void createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
    }

    @PostMapping("/delete_product")
    public void deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
    }
}
