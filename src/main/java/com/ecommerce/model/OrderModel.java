package com.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document("orders")
public class OrderModel {
    @Id
    private String orderId;
    private CustomerModel customer;
    private Map<ProductModel, Integer> products;
    private String status;
}
