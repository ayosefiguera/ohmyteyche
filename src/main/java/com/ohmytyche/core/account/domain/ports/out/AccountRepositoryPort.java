package com.ohmytyche.core.account.domain.ports.out;

import com.ohmytyche.core.account.domain.models.Account;

import java.util.List;
import java.util.Optional;

/**
 * Port interface for managing accounts in the repository.
 */
public interface AccountRepositoryPort {

    /**
     * Saves the given {@link Account} entity to the repository.
     *
     * @param account The given account to be saved.
     * @return The saved account entity.
     */
    Account save(final Account account);

    /**
     * Retrieve an {@link Account} by its unique ID.
     *
     * @param id The unique ID given.
     * @return an {@link Optional} Containing the account if found, or empty if not.
     */
    Optional<Account> findById(final Long id);

    /**
     * Retrieve all {@link Account} entities from the repository.
     *
     * @return A list of all accounts.
     */
    List<Account> findAll();

    /**
     * Updates the given {@link Account} entity in the repository.
     *
     * @param account The account to be updated.
     * @return An {@link Optional} containing the updated account if the update was successful, or empty if not.
     */
    Optional<Account> update(final Account account);

    /**
     * Deletes an {@link Account} entity by its unique ID.
     *
     * @param id The unique Id given.
     * @return {@code true} if the account was successfully deleted, {@code false}.
     */
    boolean deleteById(final Long id);
}
