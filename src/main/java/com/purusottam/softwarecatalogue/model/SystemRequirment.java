package com.purusottam.softwarecatalogue.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYSTEM_REQUIRMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SystemRequirment extends AuditableIdEntity {
    // FIXME add versionid as attribute here. each system requirement ll be against
    // a version/edition
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "VERSION_ID")
    private Long versionId;

    @Column(name = "EDITION_ID")
    private Long editionId;

    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;

    @Column(name = "CPU")
    private String cpu;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "HDD")
    private String hdd;

    @Column(name = "OTHER_DEPENDENCIES")
    private String otherDependencies;

    @Column(name = "OS_VERSION")
    private String osVersion;

    @Column(name = "PROCESSER")
    private String processor;

    @Column(name = "PROCESSER_FAMILY")
    private String processorFamily;

}
