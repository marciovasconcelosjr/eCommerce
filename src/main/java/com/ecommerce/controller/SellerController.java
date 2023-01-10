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
    public ResponseEntity<SellerModel> getById(@RequestParam Long id) {
        SellerModel seller = service.findById(id);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(seller);
        }
    }

    @GetMapping("/searchByDocument")
    public ResponseEntity<SellerModel> getByDocument(@RequestParam String document) {
        SellerModel seller = service.findByDocument(document);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(seller);
        }
    }

    @PostMapping("/registerSeller")
    public ResponseEntity<SellerModel> save(@RequestBody SellerModel sellerModel) {
        return ResponseEntity.ok(service.register(sellerModel));
    }

    @PutMapping("/updateSeller")
    public ResponseEntity<SellerModel> updated(@RequestParam Long id, @RequestBody SellerModel seller) {
        return ResponseEntity.ok(service.update(id, seller));
    }
}
