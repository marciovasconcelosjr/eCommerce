package com.ecommerce.controller;

import com.ecommerce.model.ProductModel;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<ProductModel>> getAllDesc(){
        return ResponseEntity.ok(service.listAllPriceDesc());
    }

    @GetMapping("/asc")
    public ResponseEntity<List<ProductModel>> getAllAsc(){
        return ResponseEntity.ok(service.listAllPriceAsc());
    }

    @GetMapping("/searchbyid")
    public ResponseEntity<ProductModel> getById(@RequestParam String id){
        ProductModel product = service.findById(id);
        if( product == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
    }
}