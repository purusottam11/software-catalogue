package com.purusottam.softwarecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Period;

@Entity
@Table(name = "LICENSE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class License extends AuditableIdEntity {

    // License has relation with ProsuctId,VersionId,ProductionId.
    // License amount is depend upon licenseType, licenseMetricType.(like User or in
    // group)

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "VERSION_ID")
    private Long versionId;

    @Column(name = "PRODUCT_EDITION_ID")
    private Long productEditionId;

    // findByLicense Type
    @Column(name = "LICENSE_TYPE")
    private String licenseType;

    @Column(name = "TRAIL")
    private Boolean trail;

    @Column(name = "TRIAL_PERIOD")
    private Period trailPeriod;

    @Column(name = "PRODUCTION")
    private Boolean production;

    @Column(name = "TEST")
    private Boolean test;

    @Column(name = "DEVELOPMENT")
    private Boolean development;

    @Column(name = "TRAINING")
    private Boolean training;

    @Column(name = "OTHER_RESTRICTIONS")
    private Boolean otherRestrictions;

    @Column(name = "LICENSE_CATEGORY")
    private String licenseCategory;

    @Column(name = "LICENSE_CATEGORY_DESCRIPTION")
    private String licenseCategoryDescription;

    @Column(name = "LICENSE_TYPE_DESCRIPTION")
    private String licenseTypeDescription;

    @Column(name = "LICENSE_METRIC_TYPE")
    private String licenseMetricType;

    @Column(name = "LICENSE_METRIC")
    private String licenseMetricTypeDescription;

    @Column(name = "LICENSE_METRIC_CATEGORY")
    private String licenseMetricCategory;

    @Column(name = "LICENSE_METRIC_CATEGORY_DESCRIPTION")
    private String licenseMetricCategoryDescription;


}
