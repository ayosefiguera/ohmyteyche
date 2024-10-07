package com.ohmytyche.core.account.domain.ports.in;

import com.ohmytyche.core.account.domain.models.Account;

/**
 * This interface defines uses case for creating accounts in the system.
 */
public interface CreateAccountUseCase {

    /**
     * This method takes an {@link Account} object and processes it to create a new account in the system.
     *
     * @param account The account to be created.
     * @return The created account with updated information like the account ID
     */
    Account createAccount(final Account account);
}
