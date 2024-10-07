package com.ohmytyche.core.account.application.usecases;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.in.RetrieveAccountUseCase;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link RetrieveAccountUseCase} interface.
 */
public class RetrieveAccountUseCaseImpl implements RetrieveAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;

    public RetrieveAccountUseCaseImpl(final AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    protected AccountRepositoryPort getAccountRepositoryPort() {
        return accountRepositoryPort;
    }

    @Override
    public Optional<Account> getAccountByID(final Long id) {
        return getAccountRepositoryPort().findById(id);
    }

    @Override
    public List<Account> getAllAccount() {
        return getAccountRepositoryPort().findAll();
    }
}
