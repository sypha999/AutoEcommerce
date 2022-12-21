package com.e.ecommerce.service.ServiceImplementations;

import com.e.ecommerce.DTOs.CustomerDto;
import com.e.ecommerce.DTOs.CustomerLoginDto;
import com.e.ecommerce.exceptionForRetailer.GlobalException;
import com.e.ecommerce.model.Customer;
import com.e.ecommerce.repository.CustomerRepo;
import com.e.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CustomerServiceImpl implements CustomerService {

    // Inject both customer repository and httpsession
    final CustomerRepo customerRepo;
    final HttpSession httpSession;

    //constructor
    public CustomerServiceImpl(CustomerRepo customerRepo, HttpSession httpSession) {
        this.customerRepo = customerRepo;
        this.httpSession = httpSession;
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {
        //check if customer already exist
        Customer customerExist = customerRepo.findByEmail(customerDto.getEmail());
        if(customerExist != null) throw new GlobalException("Customer already exist");

        //create new customer
        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullname());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setPassword(customerDto.getPassword());

        //save customer to data base
        customerRepo.saveAndFlush(customer);
    }

    @Override
    public void login(CustomerLoginDto loginDto) {
        //check if login details are valic
        Customer validCustomer = customerRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if(validCustomer == null) throw new GlobalException("Invalid username or password");

        //save customer to a http session
        httpSession.setAttribute("customer",validCustomer);
    }

    @Override
    public void logout() {
        //invalidate http session
        httpSession.invalidate();
    }
}
