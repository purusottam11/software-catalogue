package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.VersionBean;

import java.util.List;

public interface VersionService {

    VersionBean addVersion(VersionBean versionBean);

    VersionBean updateVersion(Long versionId, VersionBean versionBean);

    List<VersionBean> getAllVersion();

    VersionBean getVersion(Long versionId);
}
