package com.ohmytyche.core.user.domain.ports.in;

import com.ohmytyche.core.user.domain.models.User;

/**
 * This interface defines uses case for deleting users in the system.
 */
public interface DeleteUserUseCase {

    /**
     * Deletes an {@link User} identified by its unique ID.
     *
     * @param id The unique identifier of the user to be deleted.
     * @return {@code true} if the user was successfully deleted {@code false}
     * if the user could not be found or deleted.
     */
    boolean deleteUser(final Long id);

}
