package com.e.ecommerce.model;

import com.e.ecommerce.enums.DeliveryOption;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long retailerId;
    private String email;
    private String password;
    private String businessName;
    private String businessAddress;

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    @Override
    public String toString() {
        return "Retailer{" +
                "retailerId=" + retailerId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                '}';
    }
}
