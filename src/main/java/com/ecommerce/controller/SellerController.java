package com.ecommerce.controller;

import com.ecommerce.model.SellerModel;
import com.ecommerce.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService service;

    @GetMapping
    public ResponseEntity<List<SellerModel>> getAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/searchbyid")
    public ResponseEntity<SellerModel> getById(@RequestParam String id) {
        SellerModel seller = service.findById(id);
        if (seller == null) {
            throw new RuntimeException("Id not found");
        } else {
            return ResponseEntity.ok(seller);
        }
    }

    @GetMapping("/searchByDocument")
    private ResponseEntity<SellerModel> getByDocument(@RequestParam String document) {
        SellerModel seller = service.findByDocument(document);
        if (seller == null) {
            throw new RuntimeException("Document not found");
        } else {
            return ResponseEntity.ok(seller);
        }
    }

    @PostMapping("/registerCustomer")
    private ResponseEntity<SellerModel> save(@RequestBody SellerModel sellerModel) {
        return ResponseEntity.ok(service.register(sellerModel));
    }

    @PutMapping("/updateCustomer")
    private ResponseEntity<SellerModel> updated(@RequestParam String id, @RequestBody SellerModel seller) {
        return ResponseEntity.ok(service.update(id, seller));
    }
}
