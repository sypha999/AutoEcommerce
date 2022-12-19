package com.e.ecommerce.service.ServiceImplementations;

import com.e.ecommerce.DTOs.OrderDto;
import com.e.ecommerce.exceptionForCustomer.GlobalException;
import com.e.ecommerce.model.Customer;
import com.e.ecommerce.model.Orders;
import com.e.ecommerce.repository.OrderRepo;
import com.e.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class OrderServiceImpl implements OrderService {

    final OrderRepo orderRepo;
    final HttpSession httpSession;

    public OrderServiceImpl(OrderRepo orderRepo, HttpSession httpSession) {
        this.orderRepo = orderRepo;
        this.httpSession = httpSession;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        Orders orders = new Orders();

        orders.setCustomer((Customer) httpSession.getAttribute("customer"));
        orders.setQuantity(orderDto.getQuantity());
        orders.setDeliveryOption(orderDto.getDeliveryOption());
        orders.setMinPrice(orderDto.getMinPrice());
        orders.setMaxPrice(orderDto.getMaxPrice());
        orders.setProductName(orderDto.getProductName());
        orderRepo.saveAndFlush(orders);

    }

    @Override
    public void deleteOrder(Long id) {
        Orders orders = orderRepo.findById(id).orElseThrow(()-> new GlobalException("Order not found"));
        orderRepo.delete(orders);
    }
}
