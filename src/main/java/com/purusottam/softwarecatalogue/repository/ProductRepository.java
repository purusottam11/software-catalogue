package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    @Query("select p from Product p where p.publisherId =:publisherId")
    Optional<List<Product>> findProductsByPublisherId(@Param("publisherId") Long publisherId);

    @Query("select p from Product p where p.categoryId =:categoryId")
    Optional<List<Product>> findProductsByCategoryId(@Param("categoryId") Long categoryId);
}
