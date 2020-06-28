package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {

    @Query("select p from Product p where p.name=:name")
    Product findByName(@Param("name") String name);

    @Query("select p from Product p where p.name like %:searchString%")
    List<Product> searchByName(@Param("searchString") String searchString);

    @Query("select p from Product p where p.publisherId=:publisherId")
    List<Product> getProductByPublisherId(@Param("publisherId") Long publisherId);
}
