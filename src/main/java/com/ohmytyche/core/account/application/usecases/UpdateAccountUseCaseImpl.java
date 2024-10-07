package com.ohmytyche.core.account.application.usecases;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.in.UpdateAccountUseCase;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;

import java.util.Optional;

/**
 * Implementation of the {@link UpdateAccountUseCase} interface.
 */
public class UpdateAccountUseCaseImpl implements UpdateAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;

    public UpdateAccountUseCaseImpl(final AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Optional<Account> updateAccount(final Account updatedAccount) {
        return getAccountRepositoryPort().update(updatedAccount);
    }

    protected AccountRepositoryPort getAccountRepositoryPort() {
        return accountRepositoryPort;
    }
}
