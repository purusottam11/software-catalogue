package com.purusottam.softwarecatalogue.esmodel;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(indexName = "version", type = "version")
public class VersionEs {

    private Long id;

    private Long productId;

    private String version;

    private String releaseName;

    private String releaseFrequency;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date releaseDate;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date endOfLife;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date endOfSupport;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date endOfExtendedSupport;

    private Boolean status;
}
