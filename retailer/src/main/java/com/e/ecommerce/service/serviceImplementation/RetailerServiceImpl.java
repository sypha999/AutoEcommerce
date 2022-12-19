package com.e.ecommerce.service.serviceImplementation;

import com.e.ecommerce.DTOs.RetailerLoginDTO;
import com.e.ecommerce.DTOs.RetailerDTO;
import com.e.ecommerce.enums.RequestStatus;
import com.e.ecommerce.exceptionForCustomer.GlobalException1;
import com.e.ecommerce.model.OrderRequest;
import com.e.ecommerce.model.Retailer;
import com.e.ecommerce.repository.OrderRequestRepo;
import com.e.ecommerce.repository.RetailerRepo;
import com.e.ecommerce.service.RetailerService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class RetailerServiceImpl implements RetailerService {
    final RetailerRepo retailerRepo;
    final HttpSession httpSession;
    final OrderRequestRepo orderRequestRepo;

    public RetailerServiceImpl(RetailerRepo retailerRepo, HttpSession httpSession, OrderRequestRepo orderRequestRepo) {
        this.retailerRepo = retailerRepo;
        this.httpSession = httpSession;
        this.orderRequestRepo = orderRequestRepo;
    }

    @Override
    public void registerRetailer(RetailerDTO retailerDTO) {

        Retailer retailerExist = retailerRepo.findByEmail(retailerDTO.getEmail());
        if(retailerExist != null) throw new GlobalException1("User already exist");
        Retailer retailer = new Retailer();
        retailer.setPassword(retailerDTO.getPassword());
        retailer.setEmail(retailerDTO.getEmail());
        retailer.setBusinessAddress(retailerDTO.getBusinessAddress());
        retailer.setBusinessName(retailerDTO.getBusinessName());
        retailerRepo.saveAndFlush(retailer);
    }

    @Override
    public void login(RetailerLoginDTO loginDTO) {
        Retailer retailer = retailerRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if(retailer == null) throw new GlobalException1("Invalid username or password");
        httpSession.setAttribute("retailer",retailer);
    }

    @Override
    public void logout() {
        httpSession.invalidate();
    }

    @Override
    public void requestRespond(RequestStatus requestStatus, Long retailerId, Long orderRequestId) {

        Retailer retailer = retailerRepo.findByRetailerId(retailerId);
        if(retailer == null) throw new GlobalException1("Retailer does not exist");
        OrderRequest orderRequest = orderRequestRepo.findByIdAndRetailer(orderRequestId,retailer);
        if (orderRequest == null) throw new GlobalException1("Retailer has no requests yet");
        orderRequest.setRequestStatus(requestStatus);
        orderRequestRepo.saveAndFlush(orderRequest);

    }
}
