package com.purusottam.softwarecatalogue.repository;


import com.purusottam.softwarecatalogue.model.AppProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppPropertiesRepository extends BaseRepository<AppProperties> {

    @Query("select a from AppProperties a where a.groupType=:groupType")
    List<AppProperties> findByGroupType(@Param("groupType") AppProperties.GroupType groupType);

//    @Query("select a from AppProperties a where a.groupType=:groupType and a.name=:name and a.parentId=:patentId")
//    boolean findByName(@Param("groupType") AppProperties.GroupType groupType, @Param("name") String name, @Param("parentId") Long parentId);
//
//    @Query("select a from AppProperties a where a.groupType=:groupType and a.name=:name")
//    AppProperties findByLicenseMetricType(@Param("groupType") AppProperties.GroupType groupType, @Param("name") String name);

}
