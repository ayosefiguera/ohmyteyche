package com.ohmytyche.core.account.application.usecases;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.in.CreateAccountUseCase;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;

/**
 * Implementation of the {@link CreateAccountUseCase} interface.
 */
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;

    public CreateAccountUseCaseImpl(final AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Account createAccount(final Account account) {
        return getAccountRepositoryPort().save(account);
    }

    protected AccountRepositoryPort getAccountRepositoryPort() {
        return accountRepositoryPort;
    }
}
