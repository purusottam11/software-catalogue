package com.purusottam.softwarecatalogue.repository;


import com.purusottam.softwarecatalogue.model.ManufacturerSkuData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ManufacturerSkuDataRepository extends BaseRepository<ManufacturerSkuData> {

    @Query("select m from ManufacturerSkuData m where m.skuNumber=:skuNumber and m.productId=:productId and m.versionId=:versionId and m.editionId=:editionId and m.licenseId=:licenseId")
    ManufacturerSkuData findBySkuNubmer(@Param("skuNumber") String skuNumber, @Param("productId") Long productId, @Param("versionId") Long versionId, @Param("editionId") Long editionId, @Param("licenseId") Long licenseId);

    @Query("select m from ManufacturerSkuData m where m.productId=:productId")
    List<ManufacturerSkuData> getAllByProductId(@Param("productId") Long productId);

}
