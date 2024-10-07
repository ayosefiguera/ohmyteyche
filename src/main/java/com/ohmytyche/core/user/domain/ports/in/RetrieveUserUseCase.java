package com.ohmytyche.core.user.domain.ports.in;

import com.ohmytyche.core.user.domain.models.User;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines uses case for retrieving users from the system
 */
public interface RetrieveUserUseCase {

    /**
     * Retrieves an {@link User} identified by its unique ID.
     *
     * @param id The unique identifier of the user to be retrieved.
     * @return an {@link Optional} containing the user if found, or empty if not.
     */
    Optional<User> getUserById(final Long id);

    /**
     * Retrieve all {@link User}.
     *
     * @return A list of all users.
     */
    List<User> getAll();
}
