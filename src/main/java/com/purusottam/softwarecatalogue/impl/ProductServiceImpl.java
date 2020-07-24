package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.ProductBean;
import com.purusottam.softwarecatalogue.bean.PublisherBean;
import com.purusottam.softwarecatalogue.esrepo.ProductEsRepository;
import com.purusottam.softwarecatalogue.repository.CategoryRepository;
import com.purusottam.softwarecatalogue.repository.ProductRepository;
import com.purusottam.softwarecatalogue.repository.PublisherRepository;
import com.purusottam.softwarecatalogue.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public ProductBean addProduct(ProductBean productBean) {
        return null;
    }

    @Override
    public ProductBean updateProduct(ProductBean productBean, Long productId) {
        return null;
    }

    @Override
    public ProductBean getProduct(Long productId) {
        return null;
    }

    @Override
    public List<PublisherBean> getProductsByPublisherId(Long publisherId) {
        return null;
    }
}
