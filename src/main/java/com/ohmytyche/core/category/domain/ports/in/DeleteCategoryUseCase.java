package com.ohmytyche.core.category.domain.ports.in;

import com.ohmytyche.core.category.domain.models.Category;

/**
 * This interface defines uses case for deleting Categories in the system.
 */
public interface DeleteCategoryUseCase {

    /**
     * Deletes a category identified by its unique ID.
     *
     * @param id The unique identifier of the category to be deleted
     * @return {@code true} if the category was successfully deleted,
     * {@code false} if the category could not be found or deleted
     */
    boolean deleteCategory(final Long id);

    /**
     * Deletes the specified {@link Category} from the system.
     *
     * @param category The category entity to be deleted
     * @return {@code true} if the category was successfully deleted,
     * {@code false} if the category could not be found or deleted
     */
    boolean deleteCategory(final Category category);

}
