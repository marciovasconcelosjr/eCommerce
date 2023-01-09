package com.ecommerce.service;

import com.ecommerce.model.ProductModel;
import com.ecommerce.model.SellerModel;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;

    public List<ProductModel> listAll() {
        return productRepository.findAll();
    }

    public List<ProductModel> listAllPriceDesc() {
        return productRepository.findByPriceDesc();
    }

    public List<ProductModel> listAllPriceAsc() {
        return productRepository.findByPriceAsc();
    }

    public List<ProductModel> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<ProductModel> findByNameLike(String search){
        return productRepository.findByNameLike(search);
    }

    public ProductModel findById(String id) {
        Optional<ProductModel> productModelOpt = productRepository.findById(id);
        if(productModelOpt.isEmpty()) {
            return null;
        }
        return productModelOpt.get();
    }

    public ProductModel register(ProductModel productModel, String sellerId) {
        Optional<SellerModel> productSeller = sellerRepository.findById(sellerId);
        if(productSeller.isEmpty()){
            return null;
        }
        return productRepository.save(productModel);
    }
    public ProductModel update(String id, ProductModel product) {
        ProductModel productDb = findById(id);
        Optional<SellerModel> productSeller = sellerRepository.findById(product.getSellerId());
        if (!productDb.getId().equals(product.getId()) && !productSeller.isEmpty()) {
            throw new RuntimeException("Id must be equals or seller must exist");
        } else {
            return productRepository.save(product);
        }
    }

    public void deleteProduct(String id){
        ProductModel product = findById(id);
        if( product == null){
            throw new RuntimeException("Id must exist");
        }
        productRepository.deleteById(id);
    }

}
