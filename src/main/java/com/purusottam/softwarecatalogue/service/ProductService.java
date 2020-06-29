package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.ProductBean;

import java.util.List;

public interface ProductService {

    List<ProductBean> getAllProduct();

    ProductBean addProduct(ProductBean productBaen);

    ProductBean updateProduct(ProductBean productBaen);

    ProductBean getProduct(Long productId);

}
