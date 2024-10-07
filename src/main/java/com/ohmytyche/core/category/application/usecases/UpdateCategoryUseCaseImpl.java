package com.ohmytyche.core.category.application.usecases;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.in.UpdateCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;

import java.util.Optional;

/**
 * Implementation of the {@link UpdateCategoryUseCase} interfaces.
 */
public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {

    private CategoryRepositoryPort categoryRepositoryPort;

    public UpdateCategoryUseCaseImpl(final CategoryRepositoryPort categoryRepositoryPort) {
        setCategoryRepositoryPort(categoryRepositoryPort);
    }

    @Override
    public Optional<Category> updateCategory(final Category updatedCategory) {
        return getCategoryRepositoryPort().update(updatedCategory);
    }

    protected CategoryRepositoryPort getCategoryRepositoryPort() {
        return categoryRepositoryPort;
    }

    public void setCategoryRepositoryPort(final CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }
}
