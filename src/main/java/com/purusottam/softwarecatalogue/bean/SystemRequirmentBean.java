package com.purusottam.softwarecatalogue.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SystemRequirmentBean extends DataBean {

    private Long productId;

    private Long versionId;

    private String platform;

    private String cpu;

    private String ram;

    private String hdd;

    private String otherDependencies;

    private String operatingSystem;

    private String osVersion;

    private String processor;

    private String processorFamily;

}
