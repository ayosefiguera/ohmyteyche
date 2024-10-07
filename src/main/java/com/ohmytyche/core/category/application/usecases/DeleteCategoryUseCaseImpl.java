package com.ohmytyche.core.category.application.usecases;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.in.DeleteCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;

/**
 * Implementation of the {@link DeleteCategoryUseCase} interfaces.
 */
public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {

    private CategoryRepositoryPort categoryRepositoryPort;

    public DeleteCategoryUseCaseImpl(final CategoryRepositoryPort categoryRepositoryPort) {
        setCategoryRepositoryPort(categoryRepositoryPort);
    }

    @Override
    public boolean deleteCategory(final Long id) {
        return getCategoryRepositoryPort().deleteById(id);
    }

    @Override
    public boolean deleteCategory(final Category category) {
        return getCategoryRepositoryPort().deleteById(category.getId());
    }

    protected CategoryRepositoryPort getCategoryRepositoryPort() {
        return categoryRepositoryPort;
    }

    public void setCategoryRepositoryPort(final CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }
}
