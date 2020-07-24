package com.purusottam.softwarecatalogue.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Category extends AuditableIdEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PARENT_ID")
    private Long parentId;


}