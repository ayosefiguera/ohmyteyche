package com.ohmytyche.core.transaction.infrastructure.controllers;

import com.ohmytyche.core.transaction.application.services.TransactionService;
import com.ohmytyche.core.transaction.domain.models.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        setTransactionService(transactionService);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody final Transaction transaction) {
        final var transactionCreated = getTransactionService().createTransaction(transaction);
        return new ResponseEntity<>(transactionCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionByID(@PathVariable final Long id) {
        return getTransactionService().getTransactionById(id).map(transaction -> new ResponseEntity<>(transaction, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        final List<Transaction> transactions = getTransactionService().getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable final Long id, @RequestBody final Transaction transaction) {
        return getTransactionService().updateTransaction(transaction)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> deleteTransactionById(@PathVariable final Long id) {
        if (getTransactionService().deleteTransaction(id)) {
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    protected TransactionService getTransactionService() {
        return transactionService;
    }

    public void setTransactionService(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
