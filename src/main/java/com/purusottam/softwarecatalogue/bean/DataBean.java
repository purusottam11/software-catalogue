package com.purusottam.softwarecatalogue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public abstract class DataBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // FIXME should add json ignore to the below
    private Long createdBy;

    private Date createdDate = new Date();

    private Long modifiedBy;

    private Date modifiedDate = new Date();

    private Boolean deleted = false;

}