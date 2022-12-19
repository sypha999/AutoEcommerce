package com.e.ecommerce.service;

import com.e.ecommerce.model.Orders;
import com.e.ecommerce.model.Retailer;

import java.util.List;

public interface OrderRequestService {
    void findMatchingOrder(Long id);
    List<Retailer> sendOrderByBestPreferred(Long id);
}
