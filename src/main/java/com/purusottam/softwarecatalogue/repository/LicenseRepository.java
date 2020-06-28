package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.License;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LicenseRepository extends BaseRepository<License> {

    @Query("select l from License l where l.productId=:productId")
    List<License> findLicenseByProductId(@Param("productId") Long productId);

    @Query("select l from License l where l.productId=:productId and l.licenseType=:licenseType")
    License findByLicenseType(@Param("productId") Long productId, @Param("licenseType") String licenseType);

    @Query("select l from License l where l.licenseType like %:searchString%")
    List<License> searchByLicenseType(@Param("searchString") String searchString);

}
