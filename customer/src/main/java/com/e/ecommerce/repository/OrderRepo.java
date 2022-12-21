package com.e.ecommerce.repository;

import com.e.ecommerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Order repository
@Repository
public interface OrderRepo extends JpaRepository<Orders,Long> {
}
