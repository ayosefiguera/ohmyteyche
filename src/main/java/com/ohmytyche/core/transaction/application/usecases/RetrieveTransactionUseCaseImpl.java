package com.ohmytyche.core.transaction.application.usecases;

import com.ohmytyche.core.transaction.domain.models.Transaction;
import com.ohmytyche.core.transaction.domain.ports.in.RetrieveTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link RetrieveTransactionUseCase} interface.
 */
public class RetrieveTransactionUseCaseImpl implements RetrieveTransactionUseCase {

    private TransactionRepositoryPort transactionRepository;

    public RetrieveTransactionUseCaseImpl(final TransactionRepositoryPort transactionRepository) {
        setTransactionRepository(transactionRepository);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return getTransactionRepository().findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(final Long id) {
        return getTransactionRepository().findById(id);
    }

    protected TransactionRepositoryPort getTransactionRepository() {
        return transactionRepository;
    }

    public void setTransactionRepository(final TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
