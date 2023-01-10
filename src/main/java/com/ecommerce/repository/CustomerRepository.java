package com.ecommerce.repository;

import com.ecommerce.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    CustomerModel findByDocument(String document);
}
