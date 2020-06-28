package com.purusottam.softwarecatalogue.repository;


import com.purusottam.softwarecatalogue.model.PVELMapping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PVELMappingRepository extends BaseRepository<PVELMapping> {

    @Query("select pvel from PVELMapping pvel where pvel.name=:name and pvel.productId=:productId and pvel.versionId=:versionId and pvel.editionId=:editionId and pvel.licenseId=:licenseId")
    PVELMapping findByName(@Param("name") String name, @Param("productId") Long productId, @Param("versionId") Long versionId, @Param("editionId") Long editionId, @Param("licenseId") Long licenseId);

    @Query("select pvel from PVELMapping pvel where pvel.productId=:productId")
    List<PVELMapping> getAllByProductId(@Param("productId") Long productId);

    @Query("select pvel from PVELMapping pvel where pvel.name=:name")
    PVELMapping getByName(@Param("name") String name);

}
