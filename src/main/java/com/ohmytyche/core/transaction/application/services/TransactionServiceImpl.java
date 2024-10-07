package com.ohmytyche.core.transaction.application.services;

import com.ohmytyche.core.transaction.domain.models.Transaction;
import com.ohmytyche.core.transaction.domain.ports.in.CreateTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.in.DeleteTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.in.RetrieveTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.in.UpdateTransactionUseCase;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link TransactionService} interface, which combines the transaction-related use cases.
 */
public class TransactionServiceImpl implements TransactionService {

    private CreateTransactionUseCase createTransactionUseCase;
    private RetrieveTransactionUseCase retrieveTransactionUseCase;
    private UpdateTransactionUseCase updateTransactionUseCase;
    private DeleteTransactionUseCase deleteTransactionUseCase;

    public TransactionServiceImpl(final CreateTransactionUseCase createTransactionUseCase, final RetrieveTransactionUseCase retrieveTransactionUseCase, final UpdateTransactionUseCase updateTransactionUseCase, final DeleteTransactionUseCase deleteTransactionUseCase) {
        setCreateTransactionUseCase(createTransactionUseCase);
        setRetrieveTransactionUseCase(retrieveTransactionUseCase);
        setUpdateTransactionUseCase(updateTransactionUseCase);
        setRetrieveTransactionUseCase(retrieveTransactionUseCase);
    }

    @Override
    public Transaction createTransaction(final Transaction transaction) {
        return getCreateTransactionUseCase().createTransaction(transaction);
    }

    @Override
    public boolean deleteTransaction(final Long id) {
        return getDeleteTransactionUseCase().deleteTransaction(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return getRetrieveTransactionUseCase().getAllTransactions();
    }

    @Override
    public Optional<Transaction> getTransactionById(final Long id) {
        return getRetrieveTransactionUseCase().getTransactionById(id);
    }

    @Override
    public Optional<Transaction> updateTransaction(final Transaction transaction) {
        return getUpdateTransactionUseCase().updateTransaction(transaction);
    }

    protected CreateTransactionUseCase getCreateTransactionUseCase() {
        return createTransactionUseCase;
    }

    public void setCreateTransactionUseCase(final CreateTransactionUseCase createTransactionUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
    }

    protected RetrieveTransactionUseCase getRetrieveTransactionUseCase() {
        return retrieveTransactionUseCase;
    }

    public void setRetrieveTransactionUseCase(final RetrieveTransactionUseCase retrieveTransactionUseCase) {
        this.retrieveTransactionUseCase = retrieveTransactionUseCase;
    }

    protected UpdateTransactionUseCase getUpdateTransactionUseCase() {
        return updateTransactionUseCase;
    }

    public void setUpdateTransactionUseCase(final UpdateTransactionUseCase updateTransactionUseCase) {
        this.updateTransactionUseCase = updateTransactionUseCase;
    }

    protected DeleteTransactionUseCase getDeleteTransactionUseCase() {
        return deleteTransactionUseCase;
    }

    public void setDeleteTransactionUseCase(final DeleteTransactionUseCase deleteTransactionUseCase) {
        this.deleteTransactionUseCase = deleteTransactionUseCase;
    }
}
