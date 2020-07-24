package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.ProductBean;
import com.purusottam.softwarecatalogue.bean.PublisherBean;
import com.purusottam.softwarecatalogue.model.Publisher;

import java.util.List;

public interface ProductService {

    List<ProductBean> getAllProduct();

    ProductBean addProduct(ProductBean productBean);

    ProductBean updateProduct(ProductBean productBean, Long productId);

    ProductBean getProduct(Long productId);

    List<PublisherBean> getProductsByPublisherId(Long publisherId);

}
