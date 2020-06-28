package com.purusottam.softwarecatalogue.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NORMALIZATION_HINT")
@DiscriminatorColumn(name = "HINT_TYPE")
public class NormalizationHint extends AuditableIdEntity {

    @Column(name = "HINT")
    private String hint;

    // this is entity id (product id/publisher/version)
    @Column(name = "ENTITY_ID")
    private Long entityId;

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return "NormalizationHint [hint=" + hint + ", entityId=" + entityId + "]";
    }
}
