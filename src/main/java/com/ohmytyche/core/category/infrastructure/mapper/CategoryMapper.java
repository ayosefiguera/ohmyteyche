package com.ohmytyche.core.category.infrastructure.mapper;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;

/**
 * Implementation of {@link AbstractEntityMapper} for {@link CategoryMapper} and {@link Category}
 */
public class CategoryMapper extends AbstractEntityMapper<CategoryEntity, Category> {

    @Override
    public CategoryEntity toEntity(final Category source) {
        final var target = new CategoryEntity();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    @Override
    public Category toDomain(final CategoryEntity source) {
        final var target = new Category();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}
