package com.purusottam.softwarecatalogue.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PUBLISHER")
public class PublisherHint extends NormalizationHint {

}
