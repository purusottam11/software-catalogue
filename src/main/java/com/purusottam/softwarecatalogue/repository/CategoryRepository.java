package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CategoryRepository extends BaseRepository<Category> {

	@Query("select c from Category c where c.parentId=:null")
	List<Category> getCategories();

	@Query("select c from Category c where c.parentId!=:null")
	List<Category> getAllSubCategory();

	@Query("select c from Category c where c.parentId=:parentId")
	List<Category> getSubCategoriesOf(@Param("parentId") Long parentId);

	@Query("select c from Category c where c.name=:name")
	Category findByName(@Param("name") String name);

	@Query("select c from Category c where c.name like %:searchString%")
	List<Category> searchByCategory(@Param("searchString") String searchString);

	@Query("select c from Category c where c.name like %:searchString%")
	List<Category> searchBySubCategory(@Param("searchString") String searchString);

}
