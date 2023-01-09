package com.ecommerce.repository;

import com.ecommerce.model.SellerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository<SellerModel,String> {
    SellerModel findByDocument(String document);

}
