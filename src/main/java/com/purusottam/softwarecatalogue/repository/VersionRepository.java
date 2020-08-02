package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Long> {
}
