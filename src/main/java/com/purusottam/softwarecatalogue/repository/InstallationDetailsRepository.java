package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.InstallationDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstallationDetailsRepository extends BaseRepository<InstallationDetail> {

    @Query("select i from InstallationDetail i where i.productId=:productId and i.versionId=:versionId and i.editionId=:editionId and i.operatingSystem=:operatingSystem")
    InstallationDetail findByOperatingSystem(@Param("productId") Long productId, @Param("versionId") Long versionId, @Param("editionId") Long editionId, @Param("operatingSystem") String operatingSystem);

    @Query("select i from InstallationDetail i where i.productId=:productId")
    List<InstallationDetail> getAllByProductId(@Param("productId") Long productId);
}
