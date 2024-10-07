package com.ohmytyche.core.category.application.usecases;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.in.RetrieveCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link RetrieveCategoryUseCase} interfaces.
 */
public class RetrieveCategoryUseCaseImpl implements RetrieveCategoryUseCase {

    private CategoryRepositoryPort categoryRepositoryPort;

    public RetrieveCategoryUseCaseImpl(final CategoryRepositoryPort categoryRepositoryPort) {
        setCategoryRepositoryPort(categoryRepositoryPort);
    }

    @Override
    public Optional<Category> getCategoryById(final Long id) {
        return getCategoryRepositoryPort().findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return getCategoryRepositoryPort().findAll();
    }

    protected CategoryRepositoryPort getCategoryRepositoryPort() {
        return categoryRepositoryPort;
    }

    public void setCategoryRepositoryPort(final CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }
}
