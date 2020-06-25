package com.purusottam.softwarecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_PROPERTIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppProperties extends AuditableIdEntity {

    public enum GroupType {
        LICENSE_TYPE, LICENSE_CATEGORY, LICENSE_METRIC_TYPE, LICENSE_METRIC_CATEGORY;
        private String type;

        public String getType() {
            return type;
        }
    }

    @Column(name = "NAME")
    private String name;

    @Column(name = "GROUP_TYPE")
    private GroupType groupType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CODE")
    private String code;

    @Column(name = "PARENT_ID")
    private Long parentId;

}
