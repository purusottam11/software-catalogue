package com.purusottam.softwarecatalogue.esrepo;

import com.purusottam.softwarecatalogue.esmodel.LicenseEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LicenseEsRepository extends ElasticsearchRepository<LicenseEs, Long> {

}
