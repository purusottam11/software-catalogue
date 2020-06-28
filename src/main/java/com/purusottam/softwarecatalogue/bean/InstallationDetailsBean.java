package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InstallationDetailsBean extends DataBean {

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

    private Long productId;

    private Long versionId;

    private String operatingSystem;

    private String platform;

    private String osVersion;

    private String productVersion;

    private String productEdition;

    private Date productRelease;

    private String installName;

    private String deafultInstallName;

    private String md5ShaCheckSum;

    private String registryKey;

    private String registryKeyPath;

    private String comment;

    private boolean bit32;

    private boolean bit64;

}
