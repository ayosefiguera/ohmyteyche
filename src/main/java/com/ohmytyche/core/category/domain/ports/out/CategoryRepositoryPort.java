package com.ohmytyche.core.category.domain.ports.out;

import com.ohmytyche.core.category.domain.models.Category;

import java.util.List;
import java.util.Optional;

/**
 * Port interface for managing categories in the repository.
 */
public interface CategoryRepositoryPort {

    /**
     * Saves the given {@link Category} entity to the repository.
     *
     * @param category The given category to be saved.
     * @return The saved category entity.
     */
    Category save(final Category category);

    /**
     * Retrieve an {@link Category} by its unique ID.
     *
     * @param id The unique ID given.
     * @return an {@link Optional} Containing the category if found, or empty if not.
     */
    Optional<Category> findById(final Long id);

    /**
     * Retrieve all {@link Category} entities from the repository.
     *
     * @return A list of all categories.
     */
    List<Category> findAll();

    /**
     * Updates the given {@link Category} entity in the repository.
     *
     * @param category The category to be updated.
     * @return An {@link Optional} containing the updated category if the update was successful, or empty if not.
     */
    Optional<Category> update(final Category category);

    /**
     * Deletes an {@link Category} entity by its unique ID.
     *
     * @param id The unique Id given.
     * @return {@code true} if the category was successfully deleted, {@code false}.
     */
    boolean deleteById(final Long id);

}
