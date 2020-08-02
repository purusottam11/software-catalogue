package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.ProductBean;
import com.purusottam.softwarecatalogue.esmodel.ProductEs;
import com.purusottam.softwarecatalogue.esrepo.ProductEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Category;
import com.purusottam.softwarecatalogue.model.Product;
import com.purusottam.softwarecatalogue.model.Publisher;
import com.purusottam.softwarecatalogue.repository.CategoryRepository;
import com.purusottam.softwarecatalogue.repository.ProductRepository;
import com.purusottam.softwarecatalogue.repository.PublisherRepository;
import com.purusottam.softwarecatalogue.service.ProductService;
import com.purusottam.softwarecatalogue.utils.XoriskUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final PublisherRepository publisherRepository;
    private final ProductRepository productRepository;
    private final ProductEsRepository productEsRepository;

    @Override
    public List<ProductBean> getAllProduct() {
        List<ProductBean> list = XoriskUtils.copySafe(productRepository.findAll(), ProductBean.class);
        return list;
    }

    @Override
    @Transactional
    public ProductBean addProduct(ProductBean productBean) {
        Publisher publisher = publisherRepository.findById(productBean.getPublisherId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));
        productRepository.findByName(productBean.getName()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.PRODUCT_IS_EXIST.getMessage() + i.getName());
                }
        );
        Category category = categoryRepository.findById(productBean.getCategoryId()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));
        Category subcategory = categoryRepository.findById(productBean.getSubCategoryId()).orElseThrow(
                () -> new BusinessException(ErrorCode.SUB_CATEGORY_NOT_FOUND.getMessage()));
        Product product = new Product();
        XoriskUtils.copySafe(productBean, product);
        product = productRepository.save(product);
        ProductEs productEs = new ProductEs();
        XoriskUtils.copySafe(product, productEs);
        productEs = productEsRepository.save(productEs);
        XoriskUtils.copySafe(productEs, productBean);
        return productBean;
    }

    @Override
    @Transactional
    public ProductBean updateProduct(ProductBean productBean, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage()));
        Publisher publisher = publisherRepository.findById(productBean.getPublisherId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PUBLISHER_NOT_FOUND.getMessage()));
        Category category = categoryRepository.findById(productBean.getCategoryId()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND.getMessage()));
        Category subCategory = categoryRepository.findById(productBean.getSubCategoryId()).orElseThrow(
                () -> new BusinessException(ErrorCode.SUB_CATEGORY_NOT_FOUND.getMessage()));
        productRepository.findByName(productBean.getName()).ifPresent(
                i -> {
                    new BusinessException(ErrorCode.PRODUCT_IS_EXIST.getMessage() + " " + i.getName());
                }
        );

        Product newProduct = new Product();
        newProduct.setId(productId);
        XoriskUtils.copySafe(productBean, newProduct);
        newProduct = productRepository.save(newProduct);
        ProductEs productEs = new ProductEs();
        XoriskUtils.copySafe(newProduct, productEs);
        XoriskUtils.copySafe(productEsRepository.save(productEs), productBean);
        return productBean;
    }

    @Override
    public ProductBean getProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage()));
        return XoriskUtils.copySafe(product, new ProductBean());
    }

    @Override
    @Transactional
    public String deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage());
        }
        //FIXME add validation for version,edition,systemRequrement,installationDetail and license -> make sure that all the thing to be deleted also
        productRepository.deleteById(productId);
        productEsRepository.deleteById(productId);
        return "success";
    }

    @Override
    public List<ProductBean> getProductsByPublisherId(Long publisherId) {
        List<Product> list = productRepository.findProductsByPublisherId(publisherId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage()));
        List<ProductBean> beans = XoriskUtils.copySafe(list, ProductBean.class);
        return beans;
    }

    @Override
    public List<ProductBean> getProductsByCategoryId(Long categoryId) {
        List<Product> list = productRepository.findProductsByCategoryId(categoryId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        List<ProductBean> beans = XoriskUtils.copySafe(list, ProductBean.class);
        return beans;
    }


}
