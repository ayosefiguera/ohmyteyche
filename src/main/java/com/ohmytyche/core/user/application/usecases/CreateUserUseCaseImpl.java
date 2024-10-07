package com.ohmytyche.core.user.application.usecases;

import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.domain.ports.in.CreateUserCase;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;

/**
 * Implementation of the {@link CreateUserCase} interface.
 */
public class CreateUserUseCaseImpl implements CreateUserCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(final UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(final User user) {
        return getUserRepositoryPort().save(user);
    }

    protected UserRepositoryPort getUserRepositoryPort() {
        return userRepositoryPort;
    }
}
