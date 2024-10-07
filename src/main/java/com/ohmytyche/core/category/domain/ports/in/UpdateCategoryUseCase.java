package com.ohmytyche.core.category.domain.ports.in;

import com.ohmytyche.core.category.domain.models.Category;

import java.util.Optional;

/**
 * This interface defines uses case for updating Categories in the system.
 */
public interface UpdateCategoryUseCase {

    /**
     * Updates the given {@link Category}
     *
     * @param updatedCategory The category to be updated.
     * @return An {@link Optional} containing the updated category if the updated was successful, or empty if not.
     */
    Optional<Category> updateCategory(final Category updatedCategory);
}
