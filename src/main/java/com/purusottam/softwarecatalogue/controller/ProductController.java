package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.ProductBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductBean>> getProducts() {
        try {
            return new ResponseEntity<List<ProductBean>>(productService.getAllProduct(), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductBean> addProduct(@RequestBody ProductBean productBean) {
        try {
            return new ResponseEntity<ProductBean>(productService.addProduct(productBean), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductBean> updateProduct(@RequestBody ProductBean productBean, @PathVariable Long productId) {
        try {
            return new ResponseEntity<ProductBean>(productService.updateProduct(productBean, productId), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<ProductBean> getProduct(@PathVariable Long productId) {
        try {
            return new ResponseEntity<ProductBean>(productService.getProduct(productId), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        try {
            return new ResponseEntity<String>(productService.deleteProduct(productId), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getProductsByPublisherId/{publisherId}")
    public ResponseEntity<List<ProductBean>> getProductByPublisherId(@PathVariable Long publisherId) {
        try {
            return new ResponseEntity<List<ProductBean>>(productService.getProductsByPublisherId(publisherId), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getProductsByCategoryId/{categoryId}")
    public ResponseEntity<List<ProductBean>> getProductByCategoryId(@PathVariable Long categoryId) {
        try {
            return new ResponseEntity<List<ProductBean>>(productService.getProductsByCategoryId(categoryId), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
