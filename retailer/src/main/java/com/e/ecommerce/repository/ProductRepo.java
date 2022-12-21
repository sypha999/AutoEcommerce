package com.e.ecommerce.repository;

import com.e.ecommerce.enums.DeliveryOption;
import com.e.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository for Product database
@Repository
public interface ProductRepo extends JpaRepository<Products,Long> {
    Products findByProductId(Long id);

    @Query(value = "select p from Products p where p.name=?1 and p.stock >= ?2 and p.price <= ?3 and p.price >= ?4 and p.deliveryOption =?5 ")
    List<Products> findByOrder(String productName, Integer quantity, Double maxPrice, Double minPrice, DeliveryOption deliveryOption);
}
