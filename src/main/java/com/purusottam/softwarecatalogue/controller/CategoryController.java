package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.CategoryBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.model.Category;
import com.purusottam.softwarecatalogue.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/getCategories")
    public List<CategoryBean> getCategories() {
        try {
            return categoryService.getAllCategories();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PostMapping("/addCategory")
    public CategoryBean addCategory(@RequestBody CategoryBean categoryBean) {
        try {
            return categoryService.addCategory(categoryBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PostMapping("/addSubCategory")
    public CategoryBean addSubCategory(@RequestBody CategoryBean subCategoryBean) {
        try {
            return categoryService.addSubCategory(subCategoryBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/updateCategory/{categoryId}")
    public CategoryBean updateCategory(@RequestBody CategoryBean categoryBean, @PathVariable Long categoryId) {
        try {
            return categoryService.updateCategory(categoryBean, categoryId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/updateSubCategory/{subCategoryId}")
    public CategoryBean updateSubCategory(@RequestBody CategoryBean subCategoryBean, @PathVariable Long subCategoryId) {
        try {
            return categoryService.updateSubCategory(subCategoryBean, subCategoryId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getCategory/{categoryId}")
    public CategoryBean getCategory(@PathVariable Long categoryId) {
        try {
            return categoryService.getCategory(categoryId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getCategories/{parentId}")
    public List<CategoryBean> getCategoriesByParentId(@PathVariable Long parentId) {
        try {
            return categoryService.getAllSuCategoriesByParentId(parentId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        try {
            return categoryService.deleteCategory(categoryId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
