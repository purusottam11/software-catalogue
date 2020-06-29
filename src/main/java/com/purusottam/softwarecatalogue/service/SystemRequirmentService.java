package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.SystemRequirmentBean;

import java.util.List;

public interface SystemRequirmentService {

    List<SystemRequirmentBean> getAllSystemRequirment();

    SystemRequirmentBean addSystemRequirment(SystemRequirmentBean systemRequirmentBean);

    SystemRequirmentBean updateSystemRequirment(Long systemRequirementId, SystemRequirmentBean systemRequirmentBean);

    SystemRequirmentBean getSystemRequirement(Long systemRequirementId);
}
