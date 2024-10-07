package com.ohmytyche.core.transaction.infrastructure.config;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.transaction.application.services.TransactionService;
import com.ohmytyche.core.transaction.application.services.TransactionServiceImpl;
import com.ohmytyche.core.transaction.application.usecases.CreateTransactionUseCaseImpl;
import com.ohmytyche.core.transaction.application.usecases.DeleteTransactionUseCaseImpl;
import com.ohmytyche.core.transaction.application.usecases.RetrieveTransactionUseCaseImpl;
import com.ohmytyche.core.transaction.application.usecases.UpdateTransactionUseCaseImpl;
import com.ohmytyche.core.transaction.domain.ports.out.TransactionRepositoryPort;
import com.ohmytyche.core.transaction.infrastructure.mapper.TransactionMapper;
import com.ohmytyche.core.transaction.infrastructure.repositories.JpaTransactionRepository;
import com.ohmytyche.core.transaction.infrastructure.repositories.JpaTransactionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Transaction-related beans in the application.
 */
@Configuration
public class TransactionConfig {

    @Bean
    public TransactionService transactionService(final TransactionRepositoryPort transactionRepositoryPort) {
        return new TransactionServiceImpl(
                new CreateTransactionUseCaseImpl(transactionRepositoryPort),
                new RetrieveTransactionUseCaseImpl(transactionRepositoryPort),
                new UpdateTransactionUseCaseImpl(transactionRepositoryPort),
                new DeleteTransactionUseCaseImpl(transactionRepositoryPort)
        );
    }

    @Bean
    public TransactionRepositoryPort transactionRepositoryPort(final JpaTransactionRepository jpaTransactionRepository, final TransactionMapper transactionMapper) {
        return new JpaTransactionRepositoryAdapter(jpaTransactionRepository, transactionMapper);
    }

    @Bean
    public TransactionMapper transactionMapper(final AbstractEntityMapper<AccountEntity, Account> accountMapper, final AbstractEntityMapper<CategoryEntity, Category> categoryMapper) {
        return new TransactionMapper(accountMapper, categoryMapper);
    }
}
