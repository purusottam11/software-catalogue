package com.purusottam.softwarecatalogue.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VERSION")
public class VersionHint extends NormalizationHint {

}
