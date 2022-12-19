package com.e.ecommerce.exceptionForCustomer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Response> handlerForfailedException(final GlobalException e){
        Response response = new Response();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
