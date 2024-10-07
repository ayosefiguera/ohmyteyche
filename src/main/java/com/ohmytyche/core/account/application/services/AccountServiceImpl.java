package com.ohmytyche.core.account.application.services;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.in.CreateAccountUseCase;
import com.ohmytyche.core.account.domain.ports.in.DeleteAccountUseCase;
import com.ohmytyche.core.account.domain.ports.in.RetrieveAccountUseCase;
import com.ohmytyche.core.account.domain.ports.in.UpdateAccountUseCase;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link AccountService} interface, which combines the account-related use cases.
 */
public class AccountServiceImpl implements AccountService {

    private CreateAccountUseCase createAccountUseCase;
    private RetrieveAccountUseCase retrieveAccountUseCase;
    private UpdateAccountUseCase updateAccountUseCase;
    private DeleteAccountUseCase deleteAccountUseCase;

    public AccountServiceImpl(final CreateAccountUseCase createAccountUseCase,
                              final RetrieveAccountUseCase retrieveAccountUseCase,
                              final UpdateAccountUseCase updateAccountUseCase,
                              final DeleteAccountUseCase deleteAccountUseCase) {
        setCreateAccountUseCase(createAccountUseCase);
        setRetrieveAccountUseCase(retrieveAccountUseCase);
        setUpdateAccountUseCase(updateAccountUseCase);
        setDeleteAccountUseCase(deleteAccountUseCase);
    }

    @Override
    public Account createAccount(final Account account) {
        return getCreateAccountUseCase().createAccount(account);
    }

    @Override
    public boolean deleteAccount(final Long id) {
        return getDeleteAccountUseCase().deleteAccount(id);
    }

    @Override
    public Optional<Account> getAccountByID(final Long id) {
        return getRetrieveAccountUseCase().getAccountByID(id);
    }

    @Override
    public List<Account> getAllAccount() {
        return getRetrieveAccountUseCase().getAllAccount();
    }

    @Override
    public Optional<Account> updateAccount(final Account updatedAccount) {
        return getUpdateAccountUseCase().updateAccount(updatedAccount);
    }

    protected CreateAccountUseCase getCreateAccountUseCase() {
        return createAccountUseCase;
    }

    public void setCreateAccountUseCase(final CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }

    protected RetrieveAccountUseCase getRetrieveAccountUseCase() {
        return retrieveAccountUseCase;
    }

    public void setRetrieveAccountUseCase(final RetrieveAccountUseCase retrieveAccountUseCase) {
        this.retrieveAccountUseCase = retrieveAccountUseCase;
    }

    protected UpdateAccountUseCase getUpdateAccountUseCase() {
        return updateAccountUseCase;
    }

    public void setUpdateAccountUseCase(final UpdateAccountUseCase updateAccountUseCase) {
        this.updateAccountUseCase = updateAccountUseCase;
    }

    protected DeleteAccountUseCase getDeleteAccountUseCase() {
        return deleteAccountUseCase;
    }

    public void setDeleteAccountUseCase(final DeleteAccountUseCase deleteAccountUseCase) {
        this.deleteAccountUseCase = deleteAccountUseCase;
    }

}
