package com.e.ecommerce.DTOs;

import lombok.Data;

//DTO class for customer login
@Data
public class CustomerLoginDto {
    private String email;
    private String password;
}
