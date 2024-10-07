package com.ohmytyche.core.transaction.domain.ports.in;

import com.ohmytyche.core.transaction.domain.models.Transaction;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines uses cases for retrieving transactions in the system.
 */
public interface RetrieveTransactionUseCase {

    /**
     * Retrieves all {@link Transaction}.
     *
     * @return A list of all transactions.
     */
    List<Transaction> getAllTransactions();

    /**
     * Retrieves an {@link Transaction} identified by its unique ID.
     *
     * @return an {@link Optional} Containing the transaction if found, or empty if not.
     */
    Optional<Transaction> getTransactionById(final Long id);
}
