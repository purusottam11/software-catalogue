package com.purusottam.softwarecatalogue.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product extends AuditableIdEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "PUBLISHER_ID")
    private Long publisherId;

    @Column(name = "PAGE_URL")
    private String pageUrl;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private Long categoryId;

    @Column(name = "SUB_CATEGORY")
    private Long subCategoryId;

    @Column(name = "SUITE_PRODUCT")
    private Boolean suiteProduct;

    @Column(name = "BUNDLED_PRODUCT")
    private Boolean bundledProduct;

    @Column(name = "STANDALONE_PRODUCT")
    private Boolean standaloneProduct;

    @Column(name = "PORTABLE")
    private Boolean portable;

}
