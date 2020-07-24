package com.purusottam.softwarecatalogue.esmodel;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Document(indexName = "category", type = "category")
public class CategoryEs {

    private Long id;

    private String name;

    private String description;

    private Long parentId;

}
