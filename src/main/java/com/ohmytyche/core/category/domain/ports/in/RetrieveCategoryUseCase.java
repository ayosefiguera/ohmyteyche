package com.ohmytyche.core.category.domain.ports.in;

import com.ohmytyche.core.category.domain.models.Category;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines uses case for retrieving Categories in the system.
 */
public interface RetrieveCategoryUseCase {

    /**
     * Retrieves an {@link Category} identified by its unique ID.
     *
     * @param id The unique identifier of the category to be retrieved.
     * @return an {@link Optional} Containing the category if found, or empty if not.
     */
    Optional<Category> getCategoryById(final Long id);

    /**
     * Retriece all {@link Category}
     *
     * @return A list of all categories.
     */
    List<Category> getAllCategories();
}
