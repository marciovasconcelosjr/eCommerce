package com.ecommerce.service;

import com.ecommerce.model.CustomerModel;
import com.ecommerce.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<CustomerModel> listAll() {
        return repository.findAll();
    }

    public CustomerModel register(CustomerModel customerModel) {
        return repository.save(customerModel);
    }

    public CustomerModel findByDocument(String document) {
        return repository.findByDocument(document);
    }

    public CustomerModel findById(Long id) {
        Optional<CustomerModel> customerModelOpt = repository.findById(id);
        if(customerModelOpt.isEmpty()) {
            return null;
        }
        return customerModelOpt.get();
    }

    public CustomerModel update(Long id, CustomerModel customer) {
        CustomerModel customerDb = findById(id);
        if (!customerDb.getId().equals(customer.getId())) {
            throw new RuntimeException("Id must be equals");
        } else {
            return repository.save(customer);
        }
    }
}
