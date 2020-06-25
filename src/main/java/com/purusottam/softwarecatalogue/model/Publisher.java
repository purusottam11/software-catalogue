package com.purusottam.softwarecatalogue.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PUBLISHER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Publisher extends AuditableIdEntity {

    public enum PublisherType {
        SOFTWARE("Software"), HARDWARE("Hardware"), OTHER("Other");
        private String label;

        private PublisherType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "FOUNDED_DATE")
    private String foundedDate;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STATE")
    private String state;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TYPE")
    private PublisherType type;

}
