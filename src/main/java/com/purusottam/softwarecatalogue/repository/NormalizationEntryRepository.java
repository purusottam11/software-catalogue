package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.NormalizationEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NormalizationEntryRepository extends BaseRepository<NormalizationEntry> {

    @Query("select n from NormalizationEntry n where n.productName=:productName and n.publisherName=:publisherName and n.version=:version")
    NormalizationEntry findByName(@Param("productName") String productName, @Param("publisherName") String publisherName, @Param("version") String version);

}
