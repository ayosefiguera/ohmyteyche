package com.ohmytyche.core.account.domain.ports.in;

import com.ohmytyche.core.account.domain.models.Account;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines uses case for retrieving accounts from the system.
 */
public interface RetrieveAccountUseCase {

    /**
     * Retrieves an {@link Account} identified by its unique ID.
     *
     * @param id The unique identifier of the account to be retrieved.
     * @return an {@link Optional} Containing the account if found, or empty if not.
     */
    Optional<Account> getAccountByID(final Long id);

    /**
     * Retrieve all {@link Account}.
     *
     * @return A list of all accounts.
     */
    List<Account> getAllAccount();
}
