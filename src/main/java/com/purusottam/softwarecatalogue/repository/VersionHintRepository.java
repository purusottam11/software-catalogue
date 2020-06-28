package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.VersionHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VersionHintRepository extends BaseRepository<VersionHint> {

    @Query("select v from VersionHint v where v.hint=:hint")
    VersionHint findByVersionHint(@Param("hint") String hint);
}
