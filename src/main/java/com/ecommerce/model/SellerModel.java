package com.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("seller")
@Data
public class SellerModel {

    @Id
    private String id;

    private String name;

    private String document;

    private String email;

}
