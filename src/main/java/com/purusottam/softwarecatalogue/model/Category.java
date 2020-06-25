package com.purusottam.softwarecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category extends AuditableIdEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "PARENT_ID", insertable = false)
    private List<Category> subCategories;

}