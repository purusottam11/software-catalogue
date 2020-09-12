package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ProductEditionBean {

    private Long productId;

    private Long versionId;

    private String edition;

}
