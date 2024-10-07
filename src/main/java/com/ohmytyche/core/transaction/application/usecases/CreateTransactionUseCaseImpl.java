package com.ohmytyche.core.transaction.application.usecases;

import com.ohmytyche.core.transaction.domain.models.Transaction;
import com.ohmytyche.core.transaction.domain.ports.in.CreateTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;

/**
 * Implementation of {@link CreateTransactionUseCase} interface.
 */
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private TransactionRepositoryPort transactionRepository;

    public CreateTransactionUseCaseImpl(final TransactionRepositoryPort transactionRepository) {
        setTransactionRepository(transactionRepository);
    }

    @Override
    public Transaction createTransaction(final Transaction transaction) {
        return getTransactionRepository().save(transaction);
    }

    protected TransactionRepositoryPort getTransactionRepository() {
        return transactionRepository;
    }

    public void setTransactionRepository(final TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
