package com.e.ecommerce.repository;

import com.e.ecommerce.enums.RequestStatus;
import com.e.ecommerce.model.OrderRequest;
import com.e.ecommerce.model.Orders;
import com.e.ecommerce.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRequestRepo extends JpaRepository<OrderRequest,Long> {
    List<OrderRequest> findByOrdersAndRequestStatus(Orders orders, RequestStatus requestStatus);
    OrderRequest findByIdAndRetailer(Long id, Retailer retailer);
}
