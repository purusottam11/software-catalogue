package com.purusottam.softwarecatalogue.service;

import com.purusottam.softwarecatalogue.bean.LicenseBean;
import com.purusottam.softwarecatalogue.model.License;

import java.util.List;

public interface LicenseService {

    List<LicenseBean> getLicenses();

    LicenseBean addLicense(LicenseBean licenseBean);

    LicenseBean updateLicense(LicenseBean licenseBean, Long id);

    LicenseBean getLicenses(Long licenseId);

    List<License> getLicensesByProductId(Long productId);

    List<License> getLicensesByProductIdAndVersionId(Long productId, Long versionId);

    List<License> getLicensesByProductVersionIdAndEditionId(Long productId, Long versionId, Long editionId);

}
