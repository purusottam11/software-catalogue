package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.ProductEditionBean;
import com.purusottam.softwarecatalogue.esmodel.ProductEditionEs;
import com.purusottam.softwarecatalogue.esrepo.ProductEditionEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Product;
import com.purusottam.softwarecatalogue.model.ProductEdition;
import com.purusottam.softwarecatalogue.model.Version;
import com.purusottam.softwarecatalogue.repository.ProductEditionRepository;
import com.purusottam.softwarecatalogue.repository.ProductRepository;
import com.purusottam.softwarecatalogue.repository.VersionRepository;
import com.purusottam.softwarecatalogue.service.ProductEditionService;
import com.purusottam.softwarecatalogue.service.ProductService;
import com.purusottam.softwarecatalogue.service.VersionService;
import com.purusottam.softwarecatalogue.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@AllArgsConstructor
@Service
public class ProductEditionServiceImpl implements ProductEditionService {

    private final ProductService productService;
    private final VersionService versionService;
    private final ProductEditionRepository productEditionRepository;
    private final ProductEditionEsRepository productEditionEsRepository;
    private final ProductRepository productRepository;
    private final VersionRepository versionRepository;

    @Override
    @Transactional
    public ProductEditionBean addProductEdition(ProductEditionBean productEditionBean) {
        Product product = productRepository.findById(productEditionBean.getProductId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        Version version = versionRepository.findById(productEditionBean.getVersionId()).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));
        productEditionRepository.findByEditionAndProductIdAndVersionId(productEditionBean.getEdition(), productEditionBean.getProductId(), productEditionBean.getVersionId()).ifPresent(
                i -> {
                    throw new BusinessException(ErrorCode.PRODUCT_EDITION_IS_EXIST);
                }
        );
        ProductEdition productEdition = new ProductEdition();
        CopyUtils.copySafe(productEditionBean, productEdition);
        productEdition = productEditionRepository.save(productEdition);
        ProductEditionEs productEditionEs = new ProductEditionEs();
        CopyUtils.copySafe(productEdition, productEditionEs);
        productEditionEs = productEditionEsRepository.save(productEditionEs);
        CopyUtils.copySafe(productEdition, productEditionBean);
        return productEditionBean;
    }

    @Override
    @Transactional
    public ProductEditionBean updateProductEdition(ProductEditionBean productEditionBean, Long id) {
        ProductEdition productEdition = productEditionRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_EDITION_NOT_FOUND));
        Product product = productRepository.findById(productEditionBean.getProductId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        Version version = versionRepository.findById(productEditionBean.getVersionId()).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));

        productEditionRepository.findByEditionAndProductIdAndVersionId(productEditionBean.getEdition(), productEditionBean.getProductId(), productEditionBean.getVersionId())
                .ifPresent(
                        i -> {
                            throw new BusinessException(ErrorCode.PRODUCT_EDITION_IS_EXIST);
                        }
                );
        CopyUtils.copySafe(productEditionBean, productEdition);
        productEdition = productEditionRepository.save(productEdition);
        ProductEditionEs productEditionEs = new ProductEditionEs();
        CopyUtils.copySafe(productEdition, productEditionEs);
        productEditionEs = productEditionEsRepository.save(productEditionEs);
        CopyUtils.copySafe(productEdition, productEditionBean);
        return productEditionBean;
    }

    @Override
    public List<ProductEditionBean> getAllProductEdition() {
        List<ProductEditionBean> list = CopyUtils.copySafe(productEditionRepository.findAll(), ProductEditionBean.class);
        return list;
    }

    @Override
    public ProductEditionBean getEdition(Long editionId) {
        ProductEdition productEdition = productEditionRepository.findById(editionId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_EDITION_IS_EXIST));
        ProductEditionBean productEditionBean = new ProductEditionBean();
        CopyUtils.copySafe(productEdition, productEditionBean);
        return productEditionBean;
    }

    @Override
    public List<ProductEditionBean> getEditionsByProductIdAndVersionId(Long productId, Long versionId) {
        List<ProductEdition> list = productEditionRepository.findByProductIdAndVersionId(productId, versionId).get();
        List<ProductEditionBean> result = CopyUtils.copySafe(list, ProductEditionBean.class);
        return result;
    }
}
