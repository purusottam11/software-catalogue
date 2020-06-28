package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LicenseBean extends DataBean {

    private Long productId;

    private Long versionId;

    private Long productEditionId;

    private String licenseType;

    private boolean trail;

    private int period;

    private Boolean production;

    private Boolean test;

    private Boolean development;

    private Boolean training;

    private Boolean otherRestrictions;

    private String licenseCategory;

    private String licenseCategoryDescription;

    private String licenseTypeDescription;

    private String licenseMetricType;

    private String licenseMetricTypeDescription;

    private String licenseMetricCategory;

    private String licenseMetricCategoryDescription;

}
