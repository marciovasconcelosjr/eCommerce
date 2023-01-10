package com.ecommerce.repository;

import com.ecommerce.model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerModel, Long> {
    SellerModel findByDocument(String document);

}
