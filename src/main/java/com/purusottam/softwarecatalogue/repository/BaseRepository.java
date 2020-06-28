package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.IdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends IdEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

}
