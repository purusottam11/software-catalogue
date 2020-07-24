package com.purusottam.softwarecatalogue.esrepo;

import com.purusottam.softwarecatalogue.esmodel.CategoryEs;
import com.purusottam.softwarecatalogue.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface CategoryEsRepository extends ElasticsearchRepository<CategoryEs,Long> {

}
