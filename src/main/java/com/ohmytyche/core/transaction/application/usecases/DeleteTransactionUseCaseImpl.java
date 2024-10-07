package com.ohmytyche.core.transaction.application.usecases;

import com.ohmytyche.core.transaction.domain.ports.in.DeleteTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;

/**
 * Implementation of the {@link DeleteTransactionUseCase} interface.
 */
public class DeleteTransactionUseCaseImpl implements DeleteTransactionUseCase {

    private TransactionRepositoryPort transactionRepository;

    public DeleteTransactionUseCaseImpl(final TransactionRepositoryPort transactionRepository) {
        setTransactionRepository(transactionRepository);
    }

    @Override
    public boolean deleteTransaction(final Long id) {
        return getTransactionRepository().deleteById(id);
    }

    protected TransactionRepositoryPort getTransactionRepository() {
        return transactionRepository;
    }

    public void setTransactionRepository(final TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
