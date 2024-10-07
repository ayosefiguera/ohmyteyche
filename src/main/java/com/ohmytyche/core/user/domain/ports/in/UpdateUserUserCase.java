package com.ohmytyche.core.user.domain.ports.in;

import com.ohmytyche.core.user.domain.models.User;

import java.util.Optional;

/**
 * this unterface defines uses case for updating users in the system.
 */
public interface UpdateUserUserCase {

    /**
     * Update the given {@link User}
     *
     * @param user The user to be updated.
     * @return An {@link Optional} containing the updated user if the update was successful, or empty if not.
     */
    Optional<User> updateUser(final User user);
}
