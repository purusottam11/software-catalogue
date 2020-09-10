package com.purusottam.softwarecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "VERSION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Version extends AuditableIdEntity {

    // version should have composite key like (versionId,productId)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "RELEASE_NAME")
    private String releaseName;

    @Column(name = "RELEASE_FREQUENCY")
    private String releaseFrequency;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "END_OF_LIFE")
    private Date endOfLife;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "END_OF_SUPPORT")
    private Date endOfSupport;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "END_OF_EXTENDED_SUPPORT")
    private Date endOfExtendedSupport;

    @Column(name = "STATUS")
    private Boolean status;

}
