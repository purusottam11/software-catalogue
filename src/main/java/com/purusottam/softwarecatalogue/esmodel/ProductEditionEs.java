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
public class ProductEditionEs {

    private Long id;

    private Long productId;

    private Long versionId;

    private String edition;

}
