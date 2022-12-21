package com.e.ecommerce.service;

import com.e.ecommerce.DTOs.ProductDTO;

//Interface for Product service
public interface ProductService {
    void createProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
}
