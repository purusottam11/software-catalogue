package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.bean.PVELMappingBean;

import java.util.List;

public interface PVELMappingService {

    List<PVELMappingBean> getAllPvelMapping();

    PVELMappingBean addPVelMapping(PVELMappingBean pvelMappingBean);

    PVELMappingBean updatePvelMapping(Long pvelMappingId, PVELMappingBean pvelMappingBean);

    PVELMappingBean getPvelMapping(Long pvelMappingId);
}
