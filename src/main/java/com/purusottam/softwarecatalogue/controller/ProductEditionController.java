package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.ProductEditionBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.service.ProductEditionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productEdition")
@AllArgsConstructor
public class ProductEditionController {

    private final ProductEditionService productEditionService;

    @PostMapping("/addProductEdition")
    public ProductEditionBean addProductEdition(@RequestBody ProductEditionBean productEditionBean) {
        try {
            return productEditionService.addProductEdition(productEditionBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }


}
