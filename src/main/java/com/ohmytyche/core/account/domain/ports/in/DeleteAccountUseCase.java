package com.ohmytyche.core.account.domain.ports.in;

import com.ohmytyche.core.account.domain.models.Account;

/**
 * This interface defines uses case for deleting accounts in the system.
 */
public interface DeleteAccountUseCase {

    /**
     * Deletes an {@link Account} identified by its unique ID.
     *
     * @param id The unique identifier of the account to be deleted.
     * @return {@code true} if the account was successfully deleted,
     * {@code false} if the account could not be found or deleted.
     */
    boolean deleteAccount(final Long id);
}
