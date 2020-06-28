package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManufacturerSkuDataBean extends DataBean {

    private String skuNumber;

    private String cost;

    private String supportCost;

    private Long productId;

    private Long versionId;

    private Long editionId;

    private Long licenseId;

    private String comment;

    private String additionalComments;

}
