package com.e.ecommerce.model;

import com.e.ecommerce.enums.DeliveryOption;
import lombok.Data;


import javax.persistence.*;

//Model for order table
@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer quantity;
    private Double maxPrice;
    private Double minPrice;
    @Enumerated(EnumType.STRING)
    private DeliveryOption deliveryOption;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}