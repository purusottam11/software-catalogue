package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.NormalizationHint;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface HintRepository<H extends NormalizationHint> extends BaseRepository<H> {

    H findByHint(@Param("hint") String hint);

}
