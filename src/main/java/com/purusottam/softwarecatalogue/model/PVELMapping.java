
package com.purusottam.softwarecatalogue.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_VERSION_EDITION_LICENSE")
public class PVELMapping extends AuditableIdEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCT_ID")
    private Long productId;// license id has relation with product,version and edition

    @Column(name = "VERSION_ID")
    private Long versionId;

    @Column(name = "EDITION_ID")
    private Long editionId;

    @Column(name = "LICENSE_ID")
    private Long licenseId;

    @Column(name = "LINK_TO_BUNDLED_PRODUCT")
    private Long linkToBundledProductId;

    public Long getLinkToBundledProductId() {
        return linkToBundledProductId;
    }

    public void setLinkToBundledProductId(Long linkToBundledProductId) {
        this.linkToBundledProductId = linkToBundledProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getEditionId() {
        return editionId;
    }

    public void setEditionId(Long editionId) {
        this.editionId = editionId;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    @Override
    public String toString() {
        return "PVELMapping [name=" + name + ", productId=" + productId + ", versionId=" + versionId + ", editionId=" + editionId + ", licenseId=" + licenseId + ", linkToBundledProductId=" + linkToBundledProductId + "]";
    }
}
