package com.ohmytyche.core.category.application.usecases;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.in.CreateCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;

/**
 * Implementation of the {@link CreateCategoryUseCase} interfaces.
 */
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private CategoryRepositoryPort categoryRepositoryPort;

    public CreateCategoryUseCaseImpl(final CategoryRepositoryPort categoryRepositoryPort) {
        setCategoryRepositoryPort(categoryRepositoryPort);
    }

    @Override
    public Category createCategory(final Category category) {
        return getCategoryRepositoryPort().save(category);
    }

    protected CategoryRepositoryPort getCategoryRepositoryPort() {
        return categoryRepositoryPort;
    }

    public void setCategoryRepositoryPort(final CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }
}
