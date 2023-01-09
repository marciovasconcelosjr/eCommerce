package com.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
@Data
public class ProductModel {
    @Id
    private String id;
    private String sellerId;
    private String name;
    private String category;
    private String description;
    private Float price;

}
