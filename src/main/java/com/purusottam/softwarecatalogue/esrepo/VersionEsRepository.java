package com.purusottam.softwarecatalogue.esrepo;

import com.purusottam.softwarecatalogue.esmodel.VersionEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
public interface VersionEsRepository extends ElasticsearchRepository<VersionEs, Long> {
}
