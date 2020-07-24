package com.purusottam.softwarecatalogue.service;

import com.purusottam.softwarecatalogue.bean.CategoryBean;
import com.purusottam.softwarecatalogue.model.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryBean> getAllCategories();

    CategoryBean addCategory(CategoryBean categoryBean);

    CategoryBean addSubCategory(CategoryBean categoryBean);

    CategoryBean updateCategory(CategoryBean categoryBean, Long categoryId);

    CategoryBean getCategory(Long categoryId);

    CategoryBean delaCategory(Long categoryId);

    List<CategoryBean> getAllSuCategoriesByParentId(Long parentId);

}
