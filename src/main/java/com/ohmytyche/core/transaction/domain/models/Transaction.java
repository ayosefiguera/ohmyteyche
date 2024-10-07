package com.ohmytyche.core.transaction.domain.models;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.category.domain.models.Category;

import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Account account;
    private Category category;
    private Double amount;
    private LocalDateTime transactionDate;
    private LocalDateTime created;

    public Transaction() {
    }

    public Transaction(final Long id, final Account account, final Category category, final Double amount, final LocalDateTime transactionDate, final LocalDateTime created) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
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
