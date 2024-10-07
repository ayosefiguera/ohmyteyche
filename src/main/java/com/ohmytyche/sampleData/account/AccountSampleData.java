package com.ohmytyche.sampleData.account;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;
import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;
import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class AccountSampleData implements ApplicationRunner {

    @Autowired
    private Environment environment;
    @Autowired
    private AccountRepositoryPort accountRepositoryPort;
    @Autowired
    private UserRepositoryPort userRepositoryPort;
    @Autowired
    private CategoryRepositoryPort categoryRepositoryPort;
    @Autowired
    private TransactionRepositoryPort transactionRepositoryPort;

    public AccountSampleData(final Environment environment,
                             final AccountRepositoryPort accountRepositoryPort,
                             final UserRepositoryPort userRepositoryPort,
                             final CategoryRepositoryPort categoryRepositoryPort,
                             final TransactionRepositoryPort transactionRepositoryPort) {
        this.environment = environment;
        this.accountRepositoryPort = accountRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        init();
    }

    @Transactional
    private void init() {

        final var accountOne = new Account();
        accountOne.setAlias("main");
        accountOne.setBalance(1500.00);

        final var clientOne = new User();
        clientOne.setUsername("Peter");
        clientOne.setEmail("peter@example.com");
        clientOne.setCreated(LocalDateTime.now());
        clientOne.setUpdated(LocalDateTime.now());
        clientOne.setAccounts(Set.of(accountOne));
        getUserRepositoryPort().save(clientOne);

        final var categoryIncome = new Category();
        categoryIncome.setName("Income");
        final var categorySalary = new Category();
        categorySalary.setName("Salary");
        categorySalary.setSuperCategory(categoryIncome);

        final var categoryExpenses = new Category();
        categoryExpenses.setName("Expenses");
        final var categoryFood = new Category();
        categoryFood.setName("Food");
        categorySalary.setSuperCategory(categoryExpenses);

        getCategoryRepositoryPort().save(categorySalary);
        getCategoryRepositoryPort().save(categoryFood);
    }

    protected Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    protected AccountRepositoryPort getAccountRepositoryPort() {
        return accountRepositoryPort;
    }

    public void setAccountRepositoryPort(final AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    protected UserRepositoryPort getUserRepositoryPort() {
        return userRepositoryPort;
    }

    public void setUserRepositoryPort(final UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    protected CategoryRepositoryPort getCategoryRepositoryPort() {
        return categoryRepositoryPort;
    }

    public void setCategoryRepositoryPort(final CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    protected TransactionRepositoryPort getTransactionRepositoryPort() {
        return transactionRepositoryPort;
    }

    public void setTransactionRepositoryPort(final TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }
}
