package com.purusottam.softwarecatalogue.repository;


import com.purusottam.softwarecatalogue.model.ProductEdition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductEditionRepository extends BaseRepository<ProductEdition> {

    @Query("select pe from ProductEdition pe where pe.productId=:productId")
    List<ProductEdition> findEditionsByProductId(@Param("productId") Long productId);

    @Query("select pe from ProductEdition pe where pe.productId=:productId and pe.edition=:edition")
    ProductEdition findByProductIdEdition(@Param("productId") Long productId, @Param("edition") String edition);

    @Query("select pe from ProductEdition pe where pe.productId=:productId")
    List<ProductEdition> findEditionByProductId(@Param("productId") Long productId);

    @Query("select pe from ProductEdition pe where pe.edition like %:searchString%")
    List<ProductEdition> searchByEdition(@Param("searchString") String searchString);

}
