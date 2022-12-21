package com.e.ecommerce.exceptionForRetailer;

import lombok.Data;
import org.springframework.http.HttpStatus;

//Global error handler
@Data
public class Response {
    private String message;
    private HttpStatus status;
}
