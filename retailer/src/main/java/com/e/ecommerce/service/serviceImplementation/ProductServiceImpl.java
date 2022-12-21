package com.e.ecommerce.service.serviceImplementation;

import com.e.ecommerce.DTOs.ProductDTO;
import com.e.ecommerce.exceptionForRetailer.GlobalException1;
import com.e.ecommerce.model.Products;
import com.e.ecommerce.model.Retailer;
import com.e.ecommerce.repository.ProductRepo;
import com.e.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class ProductServiceImpl implements ProductService {

    final HttpSession httpSession;
    final ProductRepo productRepo;

    public ProductServiceImpl(HttpSession httpSession, ProductRepo productRepo) {
        this.httpSession = httpSession;
        this.productRepo = productRepo;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {

        //create new product
        Products products = new Products();
        products.setName(productDTO.getName());
        products.setStock(productDTO.getStock());
        products.setPrice(productDTO.getPrice());
        products.setDeliveryOption(productDTO.getDeliveryOption());

        //map product to logged in retailer
        products.setRetailer((Retailer) httpSession.getAttribute("retailer"));

        //save product to the database
        productRepo.saveAndFlush(products);
    }

    @Override
    public void deleteProduct(Long id) {

        //Delete product from database if product exist
        Products products = productRepo.findByProductId(id);
        if (products == null) throw new GlobalException1("Product does not exist");
        productRepo.delete(products);
    }
}
