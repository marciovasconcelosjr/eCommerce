package com.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customer;

    private String products;
    private String status;
}
