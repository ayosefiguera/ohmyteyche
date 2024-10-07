package com.ohmytyche.core.category.application.services;

import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.in.CreateCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.in.DeleteCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.in.RetrieveCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.in.UpdateCategoryUseCase;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link CategoryService} interfaces, which combines the category-related uses cases.
 */
public class CategoryServiceImpl implements CategoryService {

    private CreateCategoryUseCase createCategoryUseCase;
    private RetrieveCategoryUseCase retrieveCategoryUseCase;
    private UpdateCategoryUseCase updateCategoryUseCase;
    private DeleteCategoryUseCase deleteCategoryUseCase;

    public CategoryServiceImpl(final CreateCategoryUseCase createCategoryUseCase,
                               final RetrieveCategoryUseCase retrieveCategoryUseCase,
                               final UpdateCategoryUseCase updateCategoryUseCase,
                               final DeleteCategoryUseCase deleteCategoryUseCase) {
        setCreateCategoryUseCase(createCategoryUseCase);
        setRetrieveCategoryUseCase(retrieveCategoryUseCase);
        setUpdateCategoryUseCase(updateCategoryUseCase);
        setDeleteCategoryUseCase(deleteCategoryUseCase);
    }

    @Override
    public Category createCategory(final Category category) {
        return getCreateCategoryUseCase().createCategory(category);
    }

    @Override
    public boolean deleteCategory(final Long id) {
        return getDeleteCategoryUseCase().deleteCategory(id);
    }

    @Override
    public boolean deleteCategory(final Category category) {
        return getDeleteCategoryUseCase().deleteCategory(category);
    }

    @Override
    public Optional<Category> getCategoryById(final Long id) {
        return getRetrieveCategoryUseCase().getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return getRetrieveCategoryUseCase().getAllCategories();
    }

    @Override
    public Optional<Category> updateCategory(final Category updatedCategory) {
        return getUpdateCategoryUseCase().updateCategory(updatedCategory);
    }

    protected CreateCategoryUseCase getCreateCategoryUseCase() {
        return createCategoryUseCase;
    }

    public void setCreateCategoryUseCase(final CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }

    protected RetrieveCategoryUseCase getRetrieveCategoryUseCase() {
        return retrieveCategoryUseCase;
    }

    public void setRetrieveCategoryUseCase(final RetrieveCategoryUseCase retrieveCategoryUseCase) {
        this.retrieveCategoryUseCase = retrieveCategoryUseCase;
    }

    protected UpdateCategoryUseCase getUpdateCategoryUseCase() {
        return updateCategoryUseCase;
    }

    public void setUpdateCategoryUseCase(final UpdateCategoryUseCase updateCategoryUseCase) {
        this.updateCategoryUseCase = updateCategoryUseCase;
    }

    protected DeleteCategoryUseCase getDeleteCategoryUseCase() {
        return deleteCategoryUseCase;
    }

    public void setDeleteCategoryUseCase(final DeleteCategoryUseCase deleteCategoryUseCase) {
        this.deleteCategoryUseCase = deleteCategoryUseCase;
    }
}
