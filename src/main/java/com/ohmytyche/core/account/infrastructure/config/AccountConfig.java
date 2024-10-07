package com.ohmytyche.core.account.infrastructure.config;

import com.ohmytyche.core.account.application.services.AccountService;
import com.ohmytyche.core.account.application.services.AccountServiceImpl;
import com.ohmytyche.core.account.application.usecases.CreateAccountUseCaseImpl;
import com.ohmytyche.core.account.application.usecases.DeleteAccountUseCaseImpl;
import com.ohmytyche.core.account.application.usecases.RetrieveAccountUseCaseImpl;
import com.ohmytyche.core.account.application.usecases.UpdateAccountUseCaseImpl;
import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.account.infrastructure.mapper.AccountMapper;
import com.ohmytyche.core.account.infrastructure.repositories.JpaAccountRepository;
import com.ohmytyche.core.account.infrastructure.repositories.JpaAccountRepositoryAdapter;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.infrastructure.entities.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Configuration class for Account-related beans in the application.
 */
@Configuration
public class AccountConfig {

    @Bean
    public AccountService accountService(final AccountRepositoryPort accountRepositoryPort) {
        return new AccountServiceImpl(
                new CreateAccountUseCaseImpl(accountRepositoryPort),
                new RetrieveAccountUseCaseImpl(accountRepositoryPort),
                new UpdateAccountUseCaseImpl(accountRepositoryPort),
                new DeleteAccountUseCaseImpl(accountRepositoryPort)
        );
    }

    @Bean
    public AccountRepositoryPort accountRepositoryPort(final JpaAccountRepository jpaAccountRepository, final AbstractEntityMapper<AccountEntity, Account> accountMapper) {
        return new JpaAccountRepositoryAdapter(jpaAccountRepository, accountMapper);
    }

    @Bean
    public AbstractEntityMapper<AccountEntity, Account> accountMapper(final @Lazy AbstractEntityMapper<UserEntity, User> userMapper) {
        return new AccountMapper(userMapper);
    }
}
