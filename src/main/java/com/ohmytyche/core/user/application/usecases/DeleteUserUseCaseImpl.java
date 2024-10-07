package com.ohmytyche.core.user.application.usecases;

import com.ohmytyche.core.user.domain.ports.in.DeleteUserUseCase;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;

/**
 * Implementation of the {@link DeleteUserUseCase} interface.
 */
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserUseCaseImpl(final UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(final Long id) {
        getUserRepositoryPort().deleteById(id);
        return false;
    }

    protected UserRepositoryPort getUserRepositoryPort() {
        return userRepositoryPort;
    }
}
