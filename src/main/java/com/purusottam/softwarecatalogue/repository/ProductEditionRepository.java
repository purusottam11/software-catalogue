package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.ProductEdition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductEditionRepository extends JpaRepository<ProductEdition, Long> {

    Optional<ProductEdition> findByEditionAndProductIdAndVersionId(String edition, Long productId, Long versionId);

    Optional<List<ProductEdition>> findByProductIdAndVersionId(Long productId, Long versionId);

}
