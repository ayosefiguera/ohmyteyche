package com.ohmytyche.core.transaction.infrastructure.repositories;

import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.transaction.domain.models.Transaction;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;
import com.ohmytyche.core.transaction.infrastructure.entities.TransactionEntity;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link TransactionRepositoryPort} interface.
 */
public class JpaTransactionRepositoryAdapter implements TransactionRepositoryPort {

    private JpaTransactionRepository transactionRepository;
    private AbstractEntityMapper<TransactionEntity, Transaction> transactionMapper;

    public JpaTransactionRepositoryAdapter(final JpaTransactionRepository transactionRepository, final AbstractEntityMapper<TransactionEntity, Transaction> transactionMapper) {
        setTransactionRepository(transactionRepository);
        setTransactionMapper(transactionMapper);
    }

    @Override
    public Transaction save(final Transaction transaction) {
        final var transactionEntity = getTransactionMapper().toEntity(transaction);
        final var transactionSaved = getTransactionRepository().save(transactionEntity);
        return getTransactionMapper().toDomain(transactionSaved);
    }

    @Override
    public Optional<Transaction> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public List<Transaction> findAll() {
        return List.of();
    }

    @Override
    public Optional<Transaction> update(final Transaction transaction) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final Long id) {
        return false;
    }

    protected JpaTransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    public void setTransactionRepository(final JpaTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected AbstractEntityMapper<TransactionEntity, Transaction> getTransactionMapper() {
        return transactionMapper;
    }

    public void setTransactionMapper(final AbstractEntityMapper<TransactionEntity, Transaction> transactionMapper) {
        this.transactionMapper = transactionMapper;
    }
}
