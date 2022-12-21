package com.e.ecommerce.service;

import com.e.ecommerce.model.Retailer;

import java.util.List;

//Interface for Order request
public interface OrderRequestService {
    void findMatchingOrder(Long id);
    List<Retailer> sendOrderByBestPreferred(Long id);
}
