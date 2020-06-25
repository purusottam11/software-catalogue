package com.purusottam.softwarecatalogue.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MANSUFACTURE_SKU_DATA")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManufacturerSkuData extends AuditableIdEntity {

    @Column(name = "SKU_NUMBER")
    private String skuNumber;

    @Column(name = "COST")
    private String cost;

    @Column(name = "SUPPORT_COST")
    private String supportCost;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "VERSION_ID")
    private Long versionId;

    @Column(name = "EDITION_ID")
    private Long editionId;

    @Column(name = "LICENSE_ID")
    private Long licenseId;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "ADDITIONAL_COMMENT")
    private String additionalComments;

}
