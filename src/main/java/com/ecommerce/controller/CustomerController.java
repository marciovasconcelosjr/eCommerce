package com.ecommerce.controller;

import com.ecommerce.model.CustomerModel;
import com.ecommerce.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    private ResponseEntity<List<CustomerModel>> getAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/searchbyid")
    private ResponseEntity<CustomerModel> getById(@RequestParam String id) {
        CustomerModel customer = service.findById(id);
        if (customer == null) {
            throw new RuntimeException("Id not found");
        } else {
            return ResponseEntity.ok(customer);
        }
    }

    @GetMapping("/searchByDocument")
    private ResponseEntity<CustomerModel> getByDocument(@RequestParam String document) {
        CustomerModel customer = service.findByDocument(document);
        if (customer == null) {
            throw new RuntimeException("Document not found");
        } else {
            return ResponseEntity.ok(customer);
        }
    }

    @PostMapping
    private ResponseEntity<CustomerModel> save(@RequestBody CustomerModel customerModel) {
        return ResponseEntity.ok(service.register(customerModel));
    }

    @PutMapping
    private ResponseEntity<CustomerModel> updated(@RequestParam String id, @RequestBody CustomerModel customer) {
        return ResponseEntity.ok(service.update(id, customer));
    }


}
