package com.purusottam.softwarecatalogue.esrepo;

import com.purusottam.softwarecatalogue.esmodel.PublisherEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
public interface PublisherEsRepository extends ElasticsearchRepository<PublisherEs, Long> {
}
