package com.e.ecommerce.repository;

import com.e.ecommerce.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository for Retailer database
@Repository
public interface RetailerRepo extends JpaRepository<Retailer,Long> {
    Retailer findByEmailAndPassword(String email,String password);
    Retailer findByEmail(String email);
    Retailer findByRetailerId(Long id);
}
