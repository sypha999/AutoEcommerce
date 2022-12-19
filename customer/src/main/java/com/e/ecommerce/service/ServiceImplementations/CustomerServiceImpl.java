package com.e.ecommerce.service.ServiceImplementations;

import com.e.ecommerce.DTOs.CustomerDto;
import com.e.ecommerce.DTOs.CustomerLoginDto;
import com.e.ecommerce.exceptionForCustomer.GlobalException;
import com.e.ecommerce.model.Customer;
import com.e.ecommerce.repository.CustomerRepo;
import com.e.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepo customerRepo;
    final HttpSession httpSession;

    public CustomerServiceImpl(CustomerRepo customerRepo, HttpSession httpSession) {
        this.customerRepo = customerRepo;
        this.httpSession = httpSession;
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customerExist = customerRepo.findByEmail(customerDto.getEmail());
        if(customerExist != null) throw new GlobalException("Customer already exist");

        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullname());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setPassword(customerDto.getPassword());
        customerRepo.saveAndFlush(customer);
    }

    @Override
    public void login(CustomerLoginDto loginDto) {
        Customer validCustomer = customerRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if(validCustomer == null) throw new GlobalException("Invalid username or password");

        httpSession.setAttribute("customer",validCustomer);
    }

    @Override
    public void logout() {
        httpSession.invalidate();
    }
}
