package com.e.ecommerce.repository;

import com.e.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer findByEmailAndPassword(String email, String password);

    Customer findByEmail(String email);
}
