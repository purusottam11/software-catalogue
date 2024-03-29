package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.CategoryBean;
import com.purusottam.softwarecatalogue.esmodel.CategoryEs;
import com.purusottam.softwarecatalogue.esrepo.CategoryEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Category;
import com.purusottam.softwarecatalogue.repository.CategoryRepository;
import com.purusottam.softwarecatalogue.service.CategoryService;
import com.purusottam.softwarecatalogue.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryEsRepository categoryEsRepository;

    @Override
    public List<CategoryBean> getAllCategories() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryBean> beans = CopyUtils.copySafe(list, CategoryBean.class);
        return beans;
    }

    @Override
    @Transactional
    public CategoryBean addCategory(CategoryBean categoryBean) {
        categoryRepository.findById(categoryBean.getParentId()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
        categoryRepository.findByName(categoryBean.getName()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.CATEGORY_IS_EXIST.getMessage());
                });
        Category category = new Category();
        CopyUtils.copySafe(categoryBean, category);
        category = categoryRepository.save(category);
        CategoryEs categoryEs = new CategoryEs();
        CopyUtils.copySafe(category, categoryEs);
        categoryEsRepository.save(categoryEs);
        CopyUtils.copySafe(category, categoryBean);
        return categoryBean;
    }

    @Transactional
    @Override
    public CategoryBean addSubCategory(CategoryBean subCategoryBean) {
        Category category = categoryRepository.findById(subCategoryBean.getParentId()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));
        categoryRepository.findByName(subCategoryBean.getName()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.SUB_CATEGORY_IS_EXIST.getMessage());
                });

        Category subCategory = new Category();
        CopyUtils.copySafe(subCategoryBean, subCategory);
        subCategory = categoryRepository.save(subCategory);
        CategoryEs subCategoryEs = new CategoryEs();
        CopyUtils.copySafe(subCategory, subCategoryEs);
        subCategoryEs = categoryEsRepository.save(subCategoryEs);
        CopyUtils.copySafe(subCategoryEs, subCategoryBean);
        return subCategoryBean;
    }

    @Transactional
    @Override
    public CategoryBean updateCategory(CategoryBean categoryBean, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));

        CopyUtils.copySafe(categoryBean, category);
        category = categoryRepository.save(category);
        CategoryEs categoryEs = new CategoryEs();
        CopyUtils.copySafe(category, categoryEs);
        categoryEs = categoryEsRepository.save(categoryEs);
        CopyUtils.copySafe(categoryEs, categoryBean);
        return categoryBean;
    }

    @Transactional
    @Override
    public CategoryBean updateSubCategory(CategoryBean subCategoryBean, Long subCategoryId) {
        Category subCategory = categoryRepository.findById(subCategoryId).orElseThrow(
                () -> new BusinessException(ErrorCode.SUB_CATEGORY_NOT_FOUND.getMessage()));
        Category category1 = categoryRepository.findById(subCategoryBean.getParentId()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));

        CopyUtils.copySafe(subCategoryBean, subCategory);
        subCategory = categoryRepository.save(subCategory);
        CategoryEs subCategoryEs = new CategoryEs();
        CopyUtils.copySafe(subCategory, subCategoryEs);
        subCategoryEs = categoryEsRepository.save(subCategoryEs);
        CopyUtils.copySafe(subCategoryEs, subCategoryBean);
        return subCategoryBean;
    }

    @Override
    public CategoryBean getCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));
        CategoryBean categoryBean = new CategoryBean();
        CopyUtils.copySafe(category, categoryBean);
        return categoryBean;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));

        categoryRepository.getCategoriesByParentId(categoryId).ifPresent(
                i -> {
                    throw new BusinessException("You can not delete the category.....");
                }
        );
        categoryRepository.deleteById(categoryId);
        categoryEsRepository.deleteById(categoryId);
        return "success";
    }

    @Override
    public List<CategoryBean> getAllSuCategoriesByParentId(Long parentId) {
        List<Category> categories = categoryRepository.getCategoriesByParentId(parentId).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));
        List<CategoryBean> list = CopyUtils.copySafe(categories, CategoryBean.class);
        return list;
    }
}
