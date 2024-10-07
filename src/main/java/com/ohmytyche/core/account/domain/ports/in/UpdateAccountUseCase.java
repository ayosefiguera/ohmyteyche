package com.ohmytyche.core.account.domain.ports.in;

import com.ohmytyche.core.account.domain.models.Account;

import java.util.Optional;

/**
 * This interface defines uses case for updating accounts in the system.
 */
public interface UpdateAccountUseCase {

    /**
     * Updates the given {@link Account}.
     *
     * @param updatedAccount The account to be updated.
     * @return An {@link Optional} containing the updated account if the update was successful, or empty if not.
     */
    Optional<Account> updateAccount(final Account updatedAccount);
}
