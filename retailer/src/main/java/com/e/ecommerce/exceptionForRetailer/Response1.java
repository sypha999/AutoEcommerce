package com.e.ecommerce.exceptionForRetailer;

import org.springframework.http.HttpStatus;

//Global response class handler
public class Response1 {
    private String message;
    private HttpStatus status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response1{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
