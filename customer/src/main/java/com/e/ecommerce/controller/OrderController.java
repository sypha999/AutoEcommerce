package com.e.ecommerce.controller;

import com.e.ecommerce.DTOs.OrderDto;
import com.e.ecommerce.service.ServiceImplementations.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    //end point for customer to create order
    @PostMapping("/create_order")
    public void create(@RequestBody OrderDto orderDto){
        orderService.createOrder(orderDto);
    }

    //end point for customer to delete order
    @PostMapping("/delete/")
    public void delete(@RequestParam Long id){
        orderService.deleteOrder(id);
    }
}
