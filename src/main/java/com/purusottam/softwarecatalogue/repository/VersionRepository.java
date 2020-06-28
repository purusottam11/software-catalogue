package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Version;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VersionRepository extends BaseRepository<Version> {

    @Query("select v from Version v where v.version=:version and v.productId=:productId")
    Version findByVersionByVersionAndProductId(@Param("productId") Long productId, @Param("version") String version);

    @Query("select v from Version v where v.productId=:productId")
    List<Version> findVersionsByProductId(@Param("productId") Long productId);

    @Query("select v from Version v where v.version like %:searchString% ")
    List<Version> searchByName(@Param("searchString") String searchString);
}
