package com.purusottam.softwarecatalogue.esmodel;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(indexName = "license", type = "license")
public class LicenseEs {

    private Long id;

    private Long productId;

    private Long versionId;

    private Long productEditionId;

    private String licenseType;

    private Boolean trail;

    private Period trailPeriod;

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
