package com.e.ecommerce.DTOs;

import lombok.Data;

@Data
public class CustomerDto {
    private String fullname;
    private String address;
    private String email;
    private String password;

}
