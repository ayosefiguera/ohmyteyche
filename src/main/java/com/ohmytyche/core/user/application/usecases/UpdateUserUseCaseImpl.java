package com.ohmytyche.core.user.application.usecases;

import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.domain.ports.in.UpdateUserUserCase;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

/**
 * Implementation of the {@link UpdateUserUserCase} interface.
 */
public class UpdateUserUseCaseImpl implements UpdateUserUserCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImpl(final UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(final User updateddUser) {
        return getUserRepositoryPort().update(updateddUser);
    }

    protected UserRepositoryPort getUserRepositoryPort() {
        return userRepositoryPort;
    }
}
