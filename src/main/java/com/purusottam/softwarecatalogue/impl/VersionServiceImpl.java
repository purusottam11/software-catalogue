package com.purusottam.softwarecatalogue.impl;

import com.purusottam.softwarecatalogue.bean.VersionBean;
import com.purusottam.softwarecatalogue.model.Product;
import com.purusottam.softwarecatalogue.repository.ProductRepository;
import com.purusottam.softwarecatalogue.repository.VersionRepository;
import com.purusottam.softwarecatalogue.service.VersionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VersionServiceImpl implements VersionService {

    private final VersionRepository versionRepository;
    private final ProductRepository productRepository;

    @Override
    public VersionBean addVersion(VersionBean versionBean) {
        return null;
    }

    @Override
    public VersionBean updateVersion(Long versionId, VersionBean versionBean) {
        return null;
    }

    @Override
    public List<VersionBean> getAllVersion() {
        return null;
    }

    @Override
    public VersionBean getVersion(Long versionId) {
        return null;
    }

    @Override
    public String deleteVersion(Long id) {
        return null;
    }

    @Override
    public List<Product> getVersionsByProductId(Long productId) {
        return null;
    }
}
