package com.ohmytyche.core.account.domain.models;

import com.ohmytyche.core.user.domain.models.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Account {

    private Long id;
    private Set<User> users;
    private String alias;
    private Double balance;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Account() {
        this.users = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(final Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
