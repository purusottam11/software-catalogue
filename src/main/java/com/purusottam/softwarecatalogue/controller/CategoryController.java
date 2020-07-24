package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.CategoryBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
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


}
