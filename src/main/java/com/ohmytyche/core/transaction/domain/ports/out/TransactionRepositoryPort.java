package com.ohmytyche.core.transaction.domain.ports.out;

import com.ohmytyche.core.transaction.domain.models.Transaction;

import java.util.List;
import java.util.Optional;

/**
 * Port interface for managing in the repository.
 */
public interface TransactionRepositoryPort {

    /**
     * Saves the given {@link Transaction} entity to the repository.
     *
     * @param transaction The given transaction to be saved.
     * @return The saved transaction entity.
     */
    Transaction save(final Transaction transaction);

    /**
     * Retrieve en {@link Transaction} by its unique ID.
     *
     * @param id The unique ID given.
     * @return an {@link Optional} Containing the transaction if found, or empty if not.
     */
    Optional<Transaction> findById(final Long id);

    /**
     * Retrieve all {@link Transaction} entities from the repository.
     *
     * @return A list of all transactions.
     */
    List<Transaction> findAll();

    /**
     * Updates the given {@link Transaction} entity in the repository.
     *
     * @param transaction The transaction to be updated.
     * @return an {@link Optional} containing the updated transaction if the update was successful, or empty if not.
     */
    Optional<Transaction> update(final Transaction transaction);

    /**
     * Deletes an {@link Transaction} entity by its unique ID.
     *
     * @param id The unique Id given.
     * @return {@code true} if the transaction was successfully deleted, {@code false}.
     */
    boolean deleteById(final Long id);

}
