package com.ohmytyche.core.account.infrastructure.controllers;

import com.ohmytyche.core.account.application.services.AccountService;
import com.ohmytyche.core.account.domain.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService AccountService;

    public AccountController(final AccountService AccountService) {
        setAccountService(AccountService);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody final Account account) {
        final Account createdAccount = getAccountService().createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable final Long id) {
        return getAccountService().getAccountByID(id)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        final List<Account> accountList = getAccountService().getAllAccount();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable final Long id, @RequestBody final Account updateAccount) {
        return getAccountService().updateAccount(updateAccount)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccountById(@PathVariable final Long id) {
        if (getAccountService().deleteAccount(id)) {
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    protected AccountService getAccountService() {
        return AccountService;
    }

    public void setAccountService(final AccountService AccountService) {
        this.AccountService = AccountService;
    }
}
