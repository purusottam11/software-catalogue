package com.purusottam.softwarecatalogue.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRODUCT")
public class ProductHint extends NormalizationHint {

}
