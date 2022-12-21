package com.e.ecommerce.controller;

import com.e.ecommerce.model.Retailer;
import com.e.ecommerce.service.serviceImplementation.OrderRequestServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRequestController {
    final OrderRequestServiceImpl orderRequestService;

    public OrderRequestController(OrderRequestServiceImpl orderRequestService) {
        this.orderRequestService = orderRequestService;
    }

    //end point to get request from customer
    @GetMapping("/get_requests")
    public void getRequest(@RequestParam Long orderId){
        orderRequestService.findMatchingOrder(orderId);
    }

    //endpoint to send accepted request to customer
    @PostMapping("/send_accepted")
    public List<Retailer> sendAccepted(@RequestParam Long orderId){
        return orderRequestService.sendOrderByBestPreferred(orderId);
    }
}
