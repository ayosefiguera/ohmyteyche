package com.ohmytyche.core.transaction.domain.ports.in;

import com.ohmytyche.core.transaction.domain.models.Transaction;

/**
 * This interface defines uses case for creating transaction in the system.
 */
public interface CreateTransactionUseCase {

    /**
     * This method takes an {@link Transaction} object and processes it to
     * create a new transaction in the system.
     *
     * @param transaction The transaction to be created.
     * @return The transaction account with updated information like the account ID.
     */
    Transaction createTransaction(final Transaction transaction);
}
