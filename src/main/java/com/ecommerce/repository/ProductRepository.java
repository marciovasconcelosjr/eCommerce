package com.ecommerce.repository;

import com.ecommerce.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {

    List<ProductModel> findByCategory(String category);

    @Query("Select * " +
            "From product" +
            "order by price DESC;")
    List<ProductModel> findByPriceDesc();

    @Query("Select * " +
            "From product" +
            "order by price ASC;")
    List<ProductModel> findByPriceAsc();

    @Query("Select *" +
            "From product" +
            "where name Like '%:#{#search}%' ")
    List<ProductModel> findByNameLike(@Param("search") String search);
}
