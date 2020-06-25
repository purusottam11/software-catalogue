package com.purusottam.softwarecatalogue.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_VERSION_INSTALL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductVersionInstallMapping extends AuditableIdEntity {

    @Column(name = "PRODUCT_ID")
    private Long productId;// license id has relation with product,version and edition

    @Column(name = "VERSION_ID")
    private Long versionId;// DELETE

    @Column(name = "INSTALLATION_ID")
    private Long installationId;

}
