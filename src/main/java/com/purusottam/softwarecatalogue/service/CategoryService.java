package com.purusottam.softwarecatalogue.service;

import com.purusottam.softwarecatalogue.bean.CategoryBean;

import java.util.List;

public interface CategoryService {

    List<CategoryBean> getAllCategories();

    CategoryBean addCategory(CategoryBean categoryBean);

    CategoryBean updateCategory(Long categoryId, CategoryBean categoryBean);

    CategoryBean getCategory(Long categoryId);

}
