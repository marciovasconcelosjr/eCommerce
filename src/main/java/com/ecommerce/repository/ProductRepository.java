package com.ecommerce.repository;

import com.ecommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByCategory(String category);

//    @Query("Select * " +
//            "From product" +
//            "order by price DESC;")
//    List<ProductModel> findByPriceDesc();
//
//    @Query("Select * " +
//            "From product" +
//            "order by price ASC;")
//    List<ProductModel> findByPriceAsc();
//
//    @Query("Select *" +
//            "From product" +
//            "where name Like '%:#{#search}%' ")
//    List<ProductModel> findByNameLike(@Param("search") String search);
}
