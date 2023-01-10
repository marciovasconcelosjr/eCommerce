package com.ecommerce.controller;

import com.ecommerce.model.ProductModel;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ProductModel> getById(@RequestParam Long id){
        ProductModel product = service.findById(id);
        if( product == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
    }

    @GetMapping("/searchByCategory")
    public ResponseEntity<List<ProductModel>> getByCategory(@RequestParam String category){
        List<ProductModel> products = service.findByCategory(category);
        if( products.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductModel>> searchProduct(@RequestParam String search){
        List<ProductModel> products = service.findByNameLike(search);
        if( products.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @PostMapping("/registerProduct")
    public ResponseEntity<ProductModel> registerProduct(@RequestBody ProductModel productModel, @RequestParam Long sellerId){
        return ResponseEntity.ok(service.register(productModel, sellerId));
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<ProductModel> update(@RequestParam Long sellerId, @RequestBody ProductModel productModel) {
        return ResponseEntity.ok(service.update(sellerId, productModel));
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity delete(@RequestParam Long productId){
        return (ResponseEntity) ResponseEntity.ok();
    }
}