package com.ohmytyche.core.user.application.services;

import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.domain.ports.in.CreateUserCase;
import com.ohmytyche.core.user.domain.ports.in.DeleteUserUseCase;
import com.ohmytyche.core.user.domain.ports.in.RetrieveUserUseCase;
import com.ohmytyche.core.user.domain.ports.in.UpdateUserUserCase;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link UserService}, which combines the user-related use cases.
 */
public class UserServiceImpl implements UserService {

    private CreateUserCase createUserCase;
    private RetrieveUserUseCase retrieveUserUseCase;
    private UpdateUserUserCase updateUserUserCase;
    private DeleteUserUseCase deleteUserUseCase;

    public UserServiceImpl(final CreateUserCase createUserCase, final RetrieveUserUseCase retrieveUserUseCase, final UpdateUserUserCase updateUserUserCase, final DeleteUserUseCase deleteUserUseCase) {
        setCreateUserCase(createUserCase);
        setRetrieveUserUseCase(retrieveUserUseCase);
        setUpdateUserUserCase(updateUserUserCase);
        setDeleteUserUseCase(deleteUserUseCase);
    }

    @Override
    public User createUser(final User user) {
        return getCreateUserCase().createUser(user);
    }

    @Override
    public boolean deleteUser(final Long id) {
        getDeleteUserUseCase().deleteUser(id);
        return false;
    }

    @Override
    public Optional<User> getUserById(final Long id) {
        return getRetrieveUserUseCase().getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return getRetrieveUserUseCase().getAll();
    }

    @Override
    public Optional<User> updateUser(final User updatedUser) {
        return getUpdateUserUserCase().updateUser(updatedUser);
    }

    protected CreateUserCase getCreateUserCase() {
        return createUserCase;
    }

    public void setCreateUserCase(final CreateUserCase createUserCase) {
        this.createUserCase = createUserCase;
    }

    public RetrieveUserUseCase getRetrieveUserUseCase() {
        return retrieveUserUseCase;
    }

    public void setRetrieveUserUseCase(final RetrieveUserUseCase retrieveUserUseCase) {
        this.retrieveUserUseCase = retrieveUserUseCase;
    }

    public UpdateUserUserCase getUpdateUserUserCase() {
        return updateUserUserCase;
    }

    public void setUpdateUserUserCase(final UpdateUserUserCase updateUserUserCase) {
        this.updateUserUserCase = updateUserUserCase;
    }

    public DeleteUserUseCase getDeleteUserUseCase() {
        return deleteUserUseCase;
    }

    public void setDeleteUserUseCase(final DeleteUserUseCase deleteUserUseCase) {
        this.deleteUserUseCase = deleteUserUseCase;
    }
}
