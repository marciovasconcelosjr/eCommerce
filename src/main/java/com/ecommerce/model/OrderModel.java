package com.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document("orders")
public class OrderModel {
    @Id
    private String orderId;
    private String costumerId;
    private Map<ProductModel, Integer> products;
    private String status;
}
