package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Bean is always without Entity annotation it is used only for holding the data
 * form UI and the data use by controller and do operation
 *
 * @author Purusottam
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductBean {

    private String name;

    private Long publisherId;

    private String pageUrl;

    private String description;

    private Long categoryId;

    private Long subCategoryId;

    private Boolean suiteProduct;

    private Boolean bundledProduct;

    private Boolean standaloneProduct;

    private Boolean portable;

    private Long linkToBundledProduct;

//    private PublisherBean publisherBean;
//
//    private CategoryBean categoryBean;
//
//    private CategoryBean subCategoryBean;

}
