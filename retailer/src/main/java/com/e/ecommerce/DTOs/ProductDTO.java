package com.e.ecommerce.DTOs;


import com.e.ecommerce.enums.DeliveryOption;

//Product DTO class for creating product
public class ProductDTO {
    private String name;

    private Double price;
    private Integer stock;
    private DeliveryOption deliveryOption;

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(DeliveryOption deliveryOption) {
        this.deliveryOption = deliveryOption;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", deliveryOption=" + deliveryOption +
                '}';
    }

}
