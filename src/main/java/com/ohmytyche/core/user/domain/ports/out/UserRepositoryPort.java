package com.ohmytyche.core.user.domain.ports.out;

import com.ohmytyche.core.user.domain.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Port interface for managing users in the repository.
 */
public interface UserRepositoryPort {

    /**
     * Saves the given {@link User} entity to the repository.
     *
     * @param user The given user to be used.
     * @return The saved user entity.
     */
    User save(final User user);

    /**
     * Retrieve an {@link User} by its unique ID.
     *
     * @param id The unique ID given.
     * @return an {@link Optional} Containing the user if found, or empty if not.
     */
    Optional<User> findById(final Long id);

    /**
     * Retrieve all {@link User} entity in the repository.
     *
     * @return A list of all users.
     */
    List<User> findAll();

    /**
     * Updates the given {@link User} entity in the repository.
     *
     * @param user The user to be updated.
     * @return An {@link Optional} containing the updated user if the update was successful, or empty if not.
     */
    Optional<User> update(final User user);

    /**
     * Deletes an {@link User} entity by its unique ID.
     *
     * @param id The unique Id given
     */
    boolean deleteById(final Long id);
}
