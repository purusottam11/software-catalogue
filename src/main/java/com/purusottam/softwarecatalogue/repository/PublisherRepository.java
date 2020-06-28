package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Publisher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface PublisherRepository extends BaseRepository<Publisher> {

    @Query("select p from Publisher p where p.name=:name")
    Publisher findByName(@Param("name") String name);

    @Query("select p from Publisher p where p.name like %:searchString%")
    List<Publisher> searchByName(@Param("searchString") String searchString);

}
