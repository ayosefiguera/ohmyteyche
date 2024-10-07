package com.ohmytyche.core.category.infrastructure.repositories;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;
import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link CategoryRepositoryPort} interface.
 */
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {

    private JpaCategoryRepository JpaCategoryRepository;
    private AbstractEntityMapper<CategoryEntity, Category> categoryMapper;

    public JpaCategoryRepositoryAdapter(final JpaCategoryRepository jpaCategoryRepository,
                                        final AbstractEntityMapper<CategoryEntity, Category> categoryMapper) {
        setJpaCategoryRepository(jpaCategoryRepository);
        setCategoryMapper(categoryMapper);
    }

    @Override
    public Category save(final Category category) {
        final var categoryEntity = getCategoryMapper().toEntity(category);
        final var categoryEntitySaved = getJpaCategoryRepository().save(categoryEntity);
        return getCategoryMapper().toDomain(categoryEntitySaved);
    }

    @Override
    public Optional<Category> findById(final Long id) {
        return getJpaCategoryRepository().findById(id).map(getCategoryMapper()::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return getJpaCategoryRepository().findAll().stream().map(getCategoryMapper()::toDomain).toList();
    }

    @Override
    public Optional<Category> update(final Category category) {
        if (getJpaCategoryRepository().existsById(category.getId())) {
            final var categoryEntity = getCategoryMapper().toEntity(category);
            final var categoryEntityUpdated = getJpaCategoryRepository().save(categoryEntity);
            return Optional.of(getCategoryMapper().toDomain(categoryEntityUpdated));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final Long id) {
        if (getJpaCategoryRepository().existsById(id)) {
            getJpaCategoryRepository().deleteById(id);
            return true;
        }
        return false;
    }

    protected JpaCategoryRepository getJpaCategoryRepository() {
        return JpaCategoryRepository;
    }

    public void setJpaCategoryRepository(final JpaCategoryRepository jpaCategoryRepository) {
        JpaCategoryRepository = jpaCategoryRepository;
    }

    protected AbstractEntityMapper<CategoryEntity, Category> getCategoryMapper() {
        return categoryMapper;
    }

    public void setCategoryMapper(final AbstractEntityMapper<CategoryEntity, Category> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
}
