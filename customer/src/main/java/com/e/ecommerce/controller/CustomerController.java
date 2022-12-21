package com.e.ecommerce.controller;

import com.e.ecommerce.DTOs.CustomerDto;
import com.e.ecommerce.DTOs.CustomerLoginDto;
import com.e.ecommerce.service.ServiceImplementations.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    //injecting the customer service implementation
    final CustomerServiceImpl customerService;

    //constructor for customer controller
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    //end point for customer registration
    @PostMapping("/customer_register")
    public void register(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
    }

    //end point for customer login
    @PostMapping("/customer_login")
    public void login(@RequestBody CustomerLoginDto loginDto){
        customerService.login(loginDto);
    }

    //end point for customer logout
    @RequestMapping("/customer_logout")
    public void logout(){
        customerService.logout();
    }

}
