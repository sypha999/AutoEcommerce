package com.e.ecommerce.exceptionForRetailer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Global exception handler class
@RestControllerAdvice
public class GlobalExceptionHandler1 extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalException1.class)
    public ResponseEntity<Response1> handlerForfailedException(final GlobalException1 e){
        Response1 response = new Response1();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
