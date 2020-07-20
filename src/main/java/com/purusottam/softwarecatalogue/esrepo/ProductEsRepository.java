package com.purusottam.softwarecatalogue.esrepo;

import com.purusottam.softwarecatalogue.esmodel.ProductEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
public interface ProductEsRepository extends ElasticsearchRepository<ProductEs,Long> {
}
