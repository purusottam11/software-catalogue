package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.InstallationDetailsBean;

import java.util.List;

public interface InstallationDetailsService {

    List<InstallationDetailsBean> listAllInstallationDetails();

    InstallationDetailsBean addInstallationDetail(InstallationDetailsBean installationDetailsBean);

    InstallationDetailsBean updateInstallationDetails(Long installationDetailId, InstallationDetailsBean installationDetailsBean);

    InstallationDetailsBean getlInstallationDetail(Long installationDetailId);
}
