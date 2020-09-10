package com.purusottam.softwarecatalogue.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_EDITION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEdition extends AuditableIdEntity {

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "VERSION_ID")
    private Long versionId;

    @Column(name = "EDITION")
    private String edition;

}
