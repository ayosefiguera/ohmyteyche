package com.ohmytyche.core.category.domain.ports.in;

import com.ohmytyche.core.category.domain.models.Category;

/**
 * This interface defines uses case for creating Categories in the system.
 */
public interface CreateCategoryUseCase {

    /**
     * This method takes an {@link Category} object and processes it to create
     * a new category in the system.
     *
     * @param category The category to be created.
     * @return The created category with updated information like the category ID
     */
    Category createCategory(final Category category);
}
