package com.purusottam.softwarecatalogue.repository;


import com.purusottam.softwarecatalogue.model.SystemRequirment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SystemRequirmentRepository extends BaseRepository<SystemRequirment> {

    @Query("select s from SystemRequirment s where s.operatingSystem=:operatingSystem")
    SystemRequirment findBySystemRequirment(@Param("operatingSystem") String operatingSystem);

    @Query("select sr from SystemRequirment sr where sr.operatingSystem=:operatingSystem and sr.productId=:productId and sr.versionId=:versionId and sr.editionId=:editionId")
    SystemRequirment findByName(@Param("operatingSystem") String operatingSystem, @Param("productId") Long productId, @Param("versionId") Long versionId, @Param("editionId") Long editionId);

    @Query("select sr from SystemRequirment sr where sr.productId=:productId")
    List<SystemRequirment> getAllByProductId(@Param("productId") Long productId);

}
