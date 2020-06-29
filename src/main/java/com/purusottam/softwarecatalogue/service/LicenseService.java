package com.purusottam.softwarecatalogue.service;

import com.purusottam.softwarecatalogue.bean.LicenseBean;

import java.util.List;

public interface LicenseService {

    List<LicenseBean> listAllLicense();

    LicenseBean addLicense(LicenseBean licenseBean);

    LicenseBean updateLicense(LicenseBean licenseBean);

    LicenseBean getLicense(Long licenseId);

}
