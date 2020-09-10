package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VersionRepository extends JpaRepository<Version, Long> {

    Optional<Version> findByVersionAndProductId(String version, Long productId);

    Optional<List<Version>> findByProductId(Long productId);

}
