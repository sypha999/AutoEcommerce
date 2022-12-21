package com.e.ecommerce.DTOs;

import com.e.ecommerce.enums.DeliveryOption;
import lombok.Data;

//DTO class for customer to create order
@Data
public class OrderDto {
    private String productName;
    private Integer quantity;
    private Double maxPrice;
    private Double minPrice;
    private DeliveryOption deliveryOption;

}
