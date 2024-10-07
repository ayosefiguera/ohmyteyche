package com.ohmytyche.core.user.domain.models;

import com.ohmytyche.core.account.domain.models.Account;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Set<Account> accounts;

    public User() {
        this.accounts = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(final Set<Account> accounts) {
        this.accounts = accounts;
    }
}
