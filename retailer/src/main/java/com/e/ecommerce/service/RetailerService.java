package com.e.ecommerce.service;

import com.e.ecommerce.DTOs.RetailerLoginDTO;
import com.e.ecommerce.DTOs.RetailerDTO;
import com.e.ecommerce.enums.RequestStatus;

//Interface for retailer service
public interface RetailerService {
    void registerRetailer(RetailerDTO retailerDTO);
    void login(RetailerLoginDTO loginDTO);
    void logout();
    void requestRespond(RequestStatus requestStatus, Long retailerId, Long orderRequestId);
}
