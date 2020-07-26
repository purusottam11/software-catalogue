package com.purusottam.softwarecatalogue.service;

import com.purusottam.softwarecatalogue.bean.CategoryBean;
import com.purusottam.softwarecatalogue.model.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryBean> getAllCategories();

    CategoryBean addCategory(CategoryBean categoryBean);

    CategoryBean addSubCategory(CategoryBean subCategoryBean);

    CategoryBean updateCategory(CategoryBean categoryBean, Long categoryId);

    CategoryBean updateSubCategory(CategoryBean subCategoryBean, Long subCategoryId);

    CategoryBean getCategory(Long categoryId);

    CategoryBean deleteCategory(Long categoryId);

    CategoryBean deleteSubCategory(Long subCategoryId);

    List<CategoryBean> getAllSuCategoriesByParentId(Long parentId);

}
