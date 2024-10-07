package com.ohmytyche.core.transaction.infrastructure.mapper;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.transaction.domain.models.Transaction;
import com.ohmytyche.core.transaction.infrastructure.entities.TransactionEntity;

/**
 * Implementation of {@link AbstractEntityMapper} for {@link TransactionEntity} and {@link Transaction}
 */
public class TransactionMapper extends AbstractEntityMapper<TransactionEntity, Transaction> {

    private AbstractEntityMapper<AccountEntity, Account> accountMapper;
    private AbstractEntityMapper<CategoryEntity, Category> categoryMapper;

    public TransactionMapper(final AbstractEntityMapper<AccountEntity, Account> accountMapper, final AbstractEntityMapper<CategoryEntity, Category> categoryMapper) {
        setAccountMapper(accountMapper);
        setCategoryMapper(categoryMapper);
    }

    @Override
    public TransactionEntity toEntity(final Transaction source) {
        final var target = new TransactionEntity();
        target.setId(source.getId());
        target.setAccount(getAccountMapper().toEntity(source.getAccount()));
        target.setAmount(source.getAmount());
        target.setCategory(getCategoryMapper().toEntity(source.getCategory()));
        return target;
    }

    @Override
    public Transaction toDomain(final TransactionEntity source) {
        final var target = new Transaction();
        target.setId(source.getId());
        target.setAccount(getAccountMapper().toDomain(source.getAccount()));
        target.setAmount(source.getAmount());
        target.setCategory(getCategoryMapper().toDomain(source.getCategory()));
        return target;
    }

    protected AbstractEntityMapper<AccountEntity, Account> getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(final AbstractEntityMapper<AccountEntity, Account> accountMapper) {
        this.accountMapper = accountMapper;
    }

    protected AbstractEntityMapper<CategoryEntity, Category> getCategoryMapper() {
        return categoryMapper;
    }

    public void setCategoryMapper(final AbstractEntityMapper<CategoryEntity, Category> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
}
