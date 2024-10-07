package com.ohmytyche.core.user.domain.ports.in;

import com.ohmytyche.core.user.domain.models.User;

/**
 * This interface defines uses case for creating users in the system.
 */
public interface CreateUserCase {

    /**
     * This method takes an {@link User} object and processes it to create a new user in the system.
     *
     * @param user The user to be created.
     * @return The user account with updated information like the user ID.
     */
    User createUser(final User user);
}
