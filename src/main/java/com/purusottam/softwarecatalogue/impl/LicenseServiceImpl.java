package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.LicenseBean;
import com.purusottam.softwarecatalogue.esmodel.LicenseEs;
import com.purusottam.softwarecatalogue.esrepo.LicenseEsRepository;
import com.purusottam.softwarecatalogue.esrepo.ProductEditionEsRepository;
import com.purusottam.softwarecatalogue.esrepo.ProductEsRepository;
import com.purusottam.softwarecatalogue.esrepo.VersionEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.License;
import com.purusottam.softwarecatalogue.model.Product;
import com.purusottam.softwarecatalogue.model.ProductEdition;
import com.purusottam.softwarecatalogue.model.Version;
import com.purusottam.softwarecatalogue.repository.LicenseRepository;
import com.purusottam.softwarecatalogue.repository.ProductEditionRepository;
import com.purusottam.softwarecatalogue.repository.ProductRepository;
import com.purusottam.softwarecatalogue.repository.VersionRepository;
import com.purusottam.softwarecatalogue.service.LicenseService;
import com.purusottam.softwarecatalogue.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;
    private final ProductRepository productRepository;
    private final VersionRepository versionRepository;
    private final ProductEditionRepository productEditionRepository;
    private final ProductEsRepository productEsRepository;
    private final VersionEsRepository versionEsRepository;
    private final ProductEditionEsRepository productEditionEsRepository;
    private final LicenseEsRepository licenseEsRepository;


    @Override
    public List<LicenseBean> getLicenses() {
        List<License> list = licenseRepository.findAll();
        List<LicenseBean> beans = CopyUtils.copySafe(list, LicenseBean.class);
        return beans;
    }

    @Override
    @Transactional
    public LicenseBean addLicense(LicenseBean licenseBean) {
        Product product = productRepository.findById(licenseBean.getProductId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage()));
        Version version = versionRepository.findById(licenseBean.getVersionId()).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND.getMessage()));
        ProductEdition productEdition = productEditionRepository.findById(licenseBean.getProductEditionId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_EDITION_NOT_FOUND.getMessage()));

        licenseRepository.findByProductIdAndVersionIdAndProductEditionIdAndLicenseType(
                licenseBean.getProductId(), licenseBean.getVersionId(), licenseBean.getProductEditionId(), licenseBean.getLicenseType())
                .ifPresent(i -> {
                    throw new BusinessException(ErrorCode.LICENSE_IS_EXIST.getMessage());
                });

        License license = new License();
        CopyUtils.copySafe(licenseBean, license);
        license = licenseRepository.save(license);
        LicenseEs licenseEs = new LicenseEs();
        CopyUtils.copySafe(license, licenseEs);
        licenseEs = licenseEsRepository.save(licenseEs);
        CopyUtils.copySafe(license, licenseBean);
        return licenseBean;
    }

    @Override
    @Transactional
    public LicenseBean updateLicense(LicenseBean licenseBean, Long id) {
        License license = licenseRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.LICENSE_NOT_FOUND.getMessage()));
        Product product = productRepository.findById(licenseBean.getProductId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage()));
        Version version = versionRepository.findById(licenseBean.getVersionId()).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND.getMessage()));
        ProductEdition productEdition = productEditionRepository.findById(licenseBean.getProductEditionId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_EDITION_NOT_FOUND.getMessage()));

        CopyUtils.copySafe(licenseBean, license);
        license = licenseRepository.save(license);
        LicenseEs licenseEs = new LicenseEs();
        CopyUtils.copySafe(license, licenseEs);
        licenseEs = licenseEsRepository.save(licenseEs);
        CopyUtils.copySafe(license, licenseBean);
        return licenseBean;
    }

    @Override
    public LicenseBean getLicenses(Long licenseId) {
        License license = licenseRepository.findById(licenseId).orElseThrow(
                () -> new BusinessException(ErrorCode.LICENSE_NOT_FOUND.getMessage()));
        LicenseBean licenseBean = new LicenseBean();
        CopyUtils.copySafe(license, licenseBean);
        return licenseBean;
    }

    @Override
    public List<License> getLicensesByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage()));
        List<License> list = licenseRepository.findByProductId(productId).get();
        return list;
    }

    @Override
    public List<License> getLicensesByProductIdAndVersionId(Long productId, Long versionId) {
        productRepository.findById(productId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        versionRepository.findById(versionId).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));
        return licenseRepository.findByProductIdAndVersionId(productId, versionId).get();
    }

    @Override
    public List<License> getLicensesByProductVersionIdAndEditionId(Long productId, Long versionId, Long editionId) {
        productRepository.findById(productId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        versionRepository.findById(versionId).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));
        productEditionRepository.findById(editionId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_EDITION_NOT_FOUND));
        return licenseRepository.findByProductIdAndVersionIdAndProductEditionId(productId, versionId, editionId).get();
    }
}
