package com.purusottam.softwarecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AuditableIdEntity extends IdEntity {

    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate = new Date();

    @Column(name = "DELETED")
    @Type(type = "yes_no")
    private boolean deleted = false;

}