package com.e.ecommerce.service;

import com.e.ecommerce.DTOs.OrderDto;

//Order service interface
public interface OrderService {
    void createOrder(OrderDto orderDto);
    void deleteOrder(Long id);
}
