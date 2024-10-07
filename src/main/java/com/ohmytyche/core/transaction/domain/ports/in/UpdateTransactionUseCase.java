package com.ohmytyche.core.transaction.domain.ports.in;

import com.ohmytyche.core.transaction.domain.models.Transaction;

import java.util.Optional;

/**
 * This interfaces defines uses case for updating transactions in the system.
 */
public interface UpdateTransactionUseCase {

    /**
     * Updates the given {@link Transaction}
     *
     * @param transaction The transaction to be updated.
     * @return An {@link Optional} containing the updated transaction if the update was successful, or empty if not.
     */
    Optional<Transaction> updateTransaction(final Transaction transaction);
}
