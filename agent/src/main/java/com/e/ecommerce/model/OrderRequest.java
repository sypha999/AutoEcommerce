package com.e.ecommerce.model;

import com.e.ecommerce.enums.RequestStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
public class OrderRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Retailer retailer;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", orders=" + orders +
                ", retailer=" + retailer +
                ", requestStatus=" + requestStatus +
                '}';
    }
}
