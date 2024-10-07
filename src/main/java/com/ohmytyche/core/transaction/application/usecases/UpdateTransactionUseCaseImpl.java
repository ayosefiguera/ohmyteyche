package com.ohmytyche.core.transaction.application.usecases;

import com.ohmytyche.core.transaction.domain.models.Transaction;
import com.ohmytyche.core.transaction.domain.ports.in.UpdateTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;

import java.util.Optional;

/**
 * Implementation of {@link UpdateTransactionUseCase} interface.
 */
public class UpdateTransactionUseCaseImpl implements UpdateTransactionUseCase {

    private TransactionRepositoryPort transactionRepository;

    public UpdateTransactionUseCaseImpl(final TransactionRepositoryPort transactionRepository) {
        setTransactionRepository(transactionRepository);
    }

    @Override
    public Optional<Transaction> updateTransaction(final Transaction transaction) {
        return getTransactionRepository().update(transaction);
    }

    protected TransactionRepositoryPort getTransactionRepository() {
        return transactionRepository;
    }

    public void setTransactionRepository(final TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
