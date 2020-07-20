package com.purusottam.softwarecatalogue.esmodel;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(indexName = "product", type = "product")
public class ProductEs {

    private Long id;

    private String name;

    private Long publisherId;

    private String pageUrl;

    private String description;

    private Long categoryId;

    private Long subCategoryId;

    private Boolean suiteProduct;

    private Boolean bundledProduct;

    private Boolean standaloneProduct;

    private Boolean portable;

}
