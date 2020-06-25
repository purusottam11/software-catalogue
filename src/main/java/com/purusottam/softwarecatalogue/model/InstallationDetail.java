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
@Table(name = "INSTALL_DETAIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstallationDetail extends AuditableIdEntity {

    public enum OSType {
        BIT32("32 Bit"), BIT64("64 Bit"), BIT3264("32 Bit & 64 Bit");

        private String label;

        private OSType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "VERSION_ID")
    private Long versionId;

    @Column(name = "EDITION_ID")
    private Long editionId;

    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;

    @Column(name = "OS_VERSION")
    private String osVersion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "PRODUCT_RELEASE")
    private Date productRelease;

    @Column(name = "INSTALL_NAME")
    private String installName;

    @Column(name = "DEAFULT_INSTALL_NAME")
    private String deafultInstallName;

    @Column(name = "MD5SHA_CHECK_SUM")
    private String md5ShaCheckSum;

    @Column(name = "REGISTRY_KEY")
    private String registryKey;

    @Column(name = "REGISTRY_KEY_PATH")
    private String registryKeyPath;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "OS_TYPE")
    private OSType osType;

}
