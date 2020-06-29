package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.ProductEditionBean;

import java.util.List;

public interface ProductEditionService {

    ProductEditionBean addProductEdition(ProductEditionBean productEditionBean);

    ProductEditionBean updateProductEdition(ProductEditionBean productEditionBean);

    List<ProductEditionBean> getAllProductEdition();

    ProductEditionBean getEdition(Long editionId);
}
