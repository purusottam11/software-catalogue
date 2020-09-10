package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VersionBean  {

    private Long productId;

    private String version;

    private String releaseName;

    private String releaseFrequency;

    private Date releaseDate;

    private Date endOfLife;

    private Date endOfSupport;

    private Date endOfExtendedSuport;

    private boolean status;

}
