package com.e.ecommerce.service;

import com.e.ecommerce.DTOs.CustomerDto;
import com.e.ecommerce.DTOs.CustomerLoginDto;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    void login(CustomerLoginDto loginDto);
    void logout();
}
