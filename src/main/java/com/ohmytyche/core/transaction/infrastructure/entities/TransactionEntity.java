package com.ohmytyche.core.transaction.infrastructure.entities;

import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AccountEntity account;
    @ManyToOne
    private CategoryEntity category;
    private Double amount;
    private LocalDateTime transactionDate;
    private LocalDateTime created;

    public TransactionEntity() {
    }

    public TransactionEntity(final Long id, final AccountEntity account, final CategoryEntity category, final Double amount, final LocalDateTime transactionDate, final LocalDateTime created) {
        this.id = id;
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(final AccountEntity account) {
        this.account = account;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(final CategoryEntity category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(final LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }
}
