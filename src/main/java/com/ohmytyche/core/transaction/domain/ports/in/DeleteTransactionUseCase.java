package com.ohmytyche.core.transaction.domain.ports.in;

import com.ohmytyche.core.transaction.domain.models.Transaction;

/**
 * This interface defines uses case for deleting accounts in the system.
 */
public interface DeleteTransactionUseCase {

    /**
     * Deletes an {@link Transaction} identified by its unique ID.
     *
     * @param id The unique identifier of the account to be deleted.
     * @return {@code true} if the transaction was successfully deleted,
     * {@code false} if the transaction could not be found or deleted
     */
    boolean deleteTransaction(final Long id);
}
