package com.ohmytyche.core.user.application.usecases;

import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.domain.ports.in.RetrieveUserUseCase;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link RetrieveUserUseCase} interface.
 */
public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RetrieveUserUseCaseImpl(final UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUserById(final Long id) {
        return getUserRepositoryPort().findById(id);
    }

    @Override
    public List<User> getAll() {
        return getUserRepositoryPort().findAll();
    }

    protected UserRepositoryPort getUserRepositoryPort() {
        return userRepositoryPort;
    }
}
