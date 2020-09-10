package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.VersionBean;
import com.purusottam.softwarecatalogue.esmodel.VersionEs;
import com.purusottam.softwarecatalogue.esrepo.VersionEsRepository;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.model.Product;
import com.purusottam.softwarecatalogue.model.Version;
import com.purusottam.softwarecatalogue.repository.ProductRepository;
import com.purusottam.softwarecatalogue.repository.VersionRepository;
import com.purusottam.softwarecatalogue.service.VersionService;
import com.purusottam.softwarecatalogue.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VersionServiceImpl implements VersionService {

    private final VersionRepository versionRepository;
    private final ProductRepository productRepository;
    private final VersionEsRepository versionEsRepository;

    @Override
    @Transactional
    public VersionBean addVersion(VersionBean versionBean) {
        Product product = productRepository.findById(versionBean.getProductId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        versionRepository.findByVersionAndProductId(versionBean.getVersion(), versionBean.getProductId())
                .ifPresent(
                        i -> {
                            throw new BusinessException(ErrorCode.VERSION_IS_EXIST);
                        }
                );
        Version version = new Version();
        CopyUtils.copySafe(versionBean, version);
        version = versionRepository.save(version);
        VersionEs versionEs = new VersionEs();
        CopyUtils.copySafe(version, versionEs);
        versionEs = versionEsRepository.save(versionEs);
        CopyUtils.copySafe(version, versionBean);
        return versionBean;
    }

    @Override
    public VersionBean updateVersion(Long versionId, VersionBean versionBean) {
        Version version = versionRepository.findById(versionId).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));
        Product product = productRepository.findById(versionBean.getProductId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        versionRepository.findByVersionAndProductId(versionBean.getVersion(), versionBean.getProductId())
                .ifPresent(
                        i -> {
                            throw new BusinessException(ErrorCode.VERSION_IS_EXIST);
                        }
                );
        CopyUtils.copySafe(versionBean, version);
        version = versionRepository.save(version);
        VersionEs versionEs = new VersionEs();
        CopyUtils.copySafe(version, versionEs);
        versionEsRepository.save(versionEs);
        CopyUtils.copySafe(versionEs, versionBean);
        return versionBean;
    }

    @Override
    public VersionBean getVersion(Long versionId) {
        Version version = versionRepository.findById(versionId).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));
        VersionBean versionBean = new VersionBean();
        CopyUtils.copySafe(version, versionBean);
        return versionBean;
    }

    @Override
    @Transactional
    public String deleteVersion(Long id) {
        Version version = versionRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.VERSION_NOT_FOUND));
        versionRepository.deleteById(id);
        versionEsRepository.deleteById(id);
        return "success";
    }

    @Override
    public List<VersionBean> getVersionsByProductId(Long productId) {
        List<Version> list = versionRepository.findByProductId(productId).orElseThrow(
                () -> new BusinessException("There is no Versions with this product Id "));
        return CopyUtils.copySafe(list, VersionBean.class);
    }
}
