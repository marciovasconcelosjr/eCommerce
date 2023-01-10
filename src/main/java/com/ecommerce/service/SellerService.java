package com.ecommerce.service;


import com.ecommerce.model.SellerModel;
import com.ecommerce.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerService {

    private final SellerRepository repository;

    public List<SellerModel> listAll() {
        return repository.findAll();
    }

    public SellerModel register(SellerModel sellerModel) {
        return repository.save(sellerModel);
    }

    public SellerModel findByDocument(String document) {
        return repository.findByDocument(document);
    }

    public SellerModel findById(Long id) {
        Optional<SellerModel> sellerModelOpt = repository.findById(id);
        if(sellerModelOpt.isEmpty()) {
            return null;
        }
        return sellerModelOpt.get();
    }

    public SellerModel update(Long id, SellerModel seller) {
        SellerModel sellerDb = findById(id);
        if (!sellerDb.getId().equals(seller.getId())) {
            throw new RuntimeException("Id must be equals");
        } else {
            return repository.save(seller);
        }
    }

}
