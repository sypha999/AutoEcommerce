package com.e.ecommerce.service.serviceImplementation;

import com.e.ecommerce.enums.RequestStatus;
import com.e.ecommerce.exceptionForRetailer.GlobalException1;
import com.e.ecommerce.model.OrderRequest;
import com.e.ecommerce.model.Orders;
import com.e.ecommerce.model.Products;
import com.e.ecommerce.model.Retailer;
import com.e.ecommerce.repository.OrderRepo;
import com.e.ecommerce.repository.OrderRequestRepo;
import com.e.ecommerce.repository.ProductRepo;
import com.e.ecommerce.repository.RetailerRepo;
import com.e.ecommerce.service.OrderRequestService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderRequestServiceImpl implements OrderRequestService {


    final HttpSession httpSession;
    final OrderRequestRepo orderRequestRepo;
    final OrderRepo orderRepo;
    final RetailerRepo retailerRepo;
    final ProductRepo productRepo;

    public OrderRequestServiceImpl(HttpSession httpSession, OrderRequestRepo orderRequestRepo, OrderRepo orderRepo, RetailerRepo retailerRepo, ProductRepo productRepo) {
        this.httpSession = httpSession;
        this.orderRequestRepo = orderRequestRepo;
        this.orderRepo = orderRepo;
        this.retailerRepo = retailerRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void findMatchingOrder(Long id) {

        //checking if order exist
        Optional orders1 = orderRepo.findById(id);
        if(orders1.isEmpty()) throw new GlobalException1("Order not found");
        Orders orders = (Orders) orders1.get();

        //create new list to store matching product
        List<Products> matchingProducts = productRepo.findByOrder(orders.getProductName(), orders.getQuantity(), orders.getMaxPrice(), orders.getMinPrice(), orders.getDeliveryOption());
        for(Products products:matchingProducts){

            //create new order request
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.setRequestStatus(RequestStatus.PENDING);
            orderRequest.setRetailer(products.getRetailer());
            orderRequest.setOrders(orders);

            //saving order to database
            orderRequestRepo.saveAndFlush(orderRequest);
        }
    }

    @Override
    public List<Retailer> sendOrderByBestPreferred(Long id) {
        //checking if order exist
        Optional orders1 = orderRepo.findById(id);
        if(orders1.isEmpty()) throw new GlobalException1("Order not found");

        //getting order if it exist
        Orders orders = (Orders) orders1.get();
        List<OrderRequest> acceptedOrders = orderRequestRepo.findByOrdersAndRequestStatus(orders,RequestStatus.ACCEPTED);

        //create list for accepted retailers
        List<Retailer> acceptedRetailers = new ArrayList<>();
        for(OrderRequest orderRequest:acceptedOrders){
            acceptedRetailers.add(orderRequest.getRetailer());
        }

        // return accepted retailers
        return acceptedRetailers;
    }
}
