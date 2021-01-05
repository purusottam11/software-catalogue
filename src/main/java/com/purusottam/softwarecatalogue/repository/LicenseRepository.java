package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License, Long> {

    Optional<License> findByProductIdAndVersionIdAndProductEditionIdAndLicenseType(Long productId, Long versionId, Long productEditionId, String licenseType);

    Optional<List<License>> findByProductId(Long productId);

    Optional<List<License>> findByProductIdAndVersionId(Long productId, Long versionId);

    Optional<List<License>> findByProductIdAndVersionIdAndProductEditionId(Long productId, Long versionId, Long productEditionId);

}
