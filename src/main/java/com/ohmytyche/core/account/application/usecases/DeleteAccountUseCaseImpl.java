package com.ohmytyche.core.account.application.usecases;

import com.ohmytyche.core.account.domain.ports.in.DeleteAccountUseCase;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;

/**
 * Implementation of the {@link DeleteAccountUseCase} interface.
 */
public class DeleteAccountUseCaseImpl implements DeleteAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;

    public DeleteAccountUseCaseImpl(final AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public boolean deleteAccount(final Long id) {
        return getAccountRepositoryPort().deleteById(id);
    }

    protected AccountRepositoryPort getAccountRepositoryPort() {
        return accountRepositoryPort;
    }
}
