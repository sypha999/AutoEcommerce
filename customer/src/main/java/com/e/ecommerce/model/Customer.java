package com.e.ecommerce.model;

import lombok.Data;

import javax.persistence.*;


//Model for the customer table
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long CustomerId;
    private String fullName;
    @Column(name = "email")
    private String email;
    private String password;
    private String address; // for home delivery services

}
