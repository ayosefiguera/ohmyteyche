package com.ohmytyche.core.category.domain.models;

public class Category {

    private Long id;
    private String name;
    private Category superCategory;

    public Category() {
    }

    public Category(final Long id, final String name, final Category superCategory) {
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

    public Category getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(final Category superCategory) {
        this.superCategory = superCategory;
    }

}
