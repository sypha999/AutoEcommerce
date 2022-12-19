package com.e.ecommerce.service;

import com.e.ecommerce.DTOs.OrderDto;

public interface OrderService {
    void createOrder(OrderDto orderDto);
    void deleteOrder(Long id);
}
