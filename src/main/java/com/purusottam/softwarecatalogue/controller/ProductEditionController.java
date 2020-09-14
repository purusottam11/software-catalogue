package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.ProductEditionBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.model.ProductEdition;
import com.purusottam.softwarecatalogue.service.ProductEditionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PutMapping("/updateProductEdition/{id}")
    public ProductEditionBean updateProductEdition(@RequestBody ProductEditionBean productEditionBean, @PathVariable Long id) {
        try {
            return productEditionService.updateProductEdition(productEditionBean, id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getProductEdition/{id}")
    public ProductEditionBean getProductEdition(@PathVariable Long id) {
        try {
            return productEditionService.getEdition(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getEditionsByProductIdAndVersionId/{productId}/{versionId}")
    List<ProductEditionBean> getEditionsByProductIdAndVersionId(@PathVariable Long productId, @PathVariable Long versionId) {
        try {
            return productEditionService.getEditionsByProductIdAndVersionId(productId, versionId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
