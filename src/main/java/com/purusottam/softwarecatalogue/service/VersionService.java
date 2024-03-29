package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.VersionBean;
import com.purusottam.softwarecatalogue.model.Product;

import java.util.List;

public interface VersionService {

    VersionBean addVersion(VersionBean versionBean);

    VersionBean updateVersion(Long versionId, VersionBean versionBean);

    VersionBean getVersion(Long versionId);

    String deleteVersion(Long id);

    List<VersionBean> getVersionsByProductId(Long productId);

}
