package com.e.ecommerce.controller;

import com.e.ecommerce.DTOs.RetailerLoginDTO;
import com.e.ecommerce.DTOs.RetailerDTO;
import com.e.ecommerce.enums.RequestStatus;
import com.e.ecommerce.service.serviceImplementation.RetailerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailerController {

    final RetailerServiceImpl retailerService;

    public RetailerController(RetailerServiceImpl retailerService) {
        this.retailerService = retailerService;
    }


    @PostMapping("/retailer_register")
    public void registerUser(@RequestBody RetailerDTO retailerDTO){
        retailerService.registerRetailer(retailerDTO);
    }

    @PostMapping("/retailer_login")
    public void login(@RequestBody RetailerLoginDTO loginDTO){
        retailerService.login(loginDTO);
    }

    @PostMapping("/retailer_logout")
    public void logout(){
        retailerService.logout();
    }

    @PostMapping("/accept_request")
    public void accept(@RequestParam Long retailerId, @RequestParam Long orderRequestId){
        retailerService.requestRespond(RequestStatus.ACCEPTED,retailerId,orderRequestId);
    }

    @PostMapping("/reject_request")
    public void reject(@RequestParam Long retailerId, @RequestParam Long orderRequestId){
        retailerService.requestRespond(RequestStatus.REJECTED,retailerId,orderRequestId);
    }
}
