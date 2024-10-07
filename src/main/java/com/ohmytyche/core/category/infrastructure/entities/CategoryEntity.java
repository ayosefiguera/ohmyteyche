package com.ohmytyche.core.category.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;
    @ManyToOne
    private CategoryEntity superCategory;

    public CategoryEntity() {
    }

    public CategoryEntity(final Long id, final String name, final CategoryEntity superCategory) {
        this.id = id;
        this.name = name;
        this.superCategory = superCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public CategoryEntity getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(final CategoryEntity superCategory) {
        this.superCategory = superCategory;
    }
}
