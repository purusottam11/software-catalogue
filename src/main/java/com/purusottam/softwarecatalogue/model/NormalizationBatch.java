package com.purusottam.softwarecatalogue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NORMALIZATION_BATCH")
public class NormalizationBatch extends AuditableIdEntity {

    public enum Status {
        INITIAL, IN_PROCESS, COMPLETED, CLOSED;
    }

    @Column(name = "TOTAL_ENTRIES")
    private int totalEntries;

    @Column(name = "TOTAL_RESOLVED")
    private int totalResolved;

    // FIXME this is how you set a default value for a enum
    @Column(name = "STATUS", nullable = false, columnDefinition = "varchar(32) default 'INITIAL'")
    private Status status = Status.INITIAL;

    // FIXME add mapping to the NormalizationEntries this should be a
    // List<NormalizationEntry>
    @Column(name = "NORMALIZATION_ENTRY")
    private ArrayList<NormalizationBatch> normalizationEntry;

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }

    public int getTotalResolved() {
        return totalResolved;
    }

    public void setTotalResolved(int totalResolved) {
        this.totalResolved = totalResolved;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<NormalizationBatch> getNormalizationEntry() {
        return normalizationEntry;
    }

    public void setNormalizationEntry(List<NormalizationBatch> normalizationEntry) {
        this.normalizationEntry = (ArrayList<NormalizationBatch>) normalizationEntry;
    }

    @Override
    public String toString() {
        return "NormalizationBatch [totalEntries=" + totalEntries + ", totalResolved=" + totalResolved + ", status=" + status + ", normalizationEntry=" + normalizationEntry + "]";
    }

}
