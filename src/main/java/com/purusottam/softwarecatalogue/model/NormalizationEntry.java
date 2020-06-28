package com.purusottam.softwarecatalogue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NORMALIZATION_ENTRY")
public class NormalizationEntry extends AuditableIdEntity {

    @Column(name = "BATCH_ID")
    private Long batchId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PUBLISHER_NAME")
    private String publisherName;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "RESOLUTION_TYPE")
    private String resolutionType;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PUBLISHER_ID")
    private Long publisherId;

    @Column(name = "VERSION_ID")
    private Long versionId;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getResolutionType() {
        return resolutionType;
    }

    public void setResolutionType(String resolutionType) {
        this.resolutionType = resolutionType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "NormalizationEntry [batchId=" + batchId + ", productName=" + productName + ", publisherName=" + publisherName + ", version=" + version + ", resolutionType=" + resolutionType + ", productId=" + productId + ", publisherId="
                + publisherId + ", versionId=" + versionId + "]";
    }

}
