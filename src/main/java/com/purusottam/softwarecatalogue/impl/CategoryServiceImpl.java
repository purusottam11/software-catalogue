package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.CategoryBean;
import com.purusottam.softwarecatalogue.esmodel.CategoryEs;
import com.purusottam.softwarecatalogue.esrepo.CategoryEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Category;
import com.purusottam.softwarecatalogue.repository.CategoryRepository;
import com.purusottam.softwarecatalogue.service.CategoryService;
import com.purusottam.softwarecatalogue.utils.XoriskUtils;
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
        List<CategoryBean> list = XoriskUtils.copySafe((List<?>) categoryEsRepository.findAll(), CategoryBean.class);
        return list;
    }

    @Override
    @Transactional
    public CategoryBean addCategory(CategoryBean categoryBean) {
        categoryRepository.findByName(categoryBean.getName()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.CATEGORY_IS_EXIST.getMessage());
                });
        Category category = new Category();
        XoriskUtils.copySafe(categoryBean, category);
        category = categoryRepository.save(category);
        CategoryEs categoryEs = new CategoryEs();
        XoriskUtils.copySafe(category, categoryEs);
        categoryEsRepository.save(categoryEs);
        XoriskUtils.copySafe(category, categoryBean);
        return categoryBean;
    }

    @Override
    @Transactional
    public CategoryBean addSubCategory(CategoryBean categoryBean) {

        return null;
    }

    @Override
    public CategoryBean updateCategory(CategoryBean categoryBean, Long categoryId) {
        return null;
    }

    @Override
    public CategoryBean getCategory(Long categoryId) {
        return null;
    }

    @Override
    public CategoryBean delaCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<CategoryBean> getAllSuCategoriesByParentId(Long parentId) {
        return null;
    }
}
