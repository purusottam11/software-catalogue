package com.purusottam.softwarecatalogue.esrepo;

import com.purusottam.softwarecatalogue.esmodel.ProductEditionEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductEditionEsRepository extends ElasticsearchRepository<ProductEditionEs, Long> {
}
