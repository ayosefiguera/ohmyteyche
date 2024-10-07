package com.ohmytyche.core.user.infrastructure.config;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.user.application.services.UserService;
import com.ohmytyche.core.user.application.services.UserServiceImpl;
import com.ohmytyche.core.user.application.usecases.CreateUserUseCaseImpl;
import com.ohmytyche.core.user.application.usecases.DeleteUserUseCaseImpl;
import com.ohmytyche.core.user.application.usecases.RetrieveUserUseCaseImpl;
import com.ohmytyche.core.user.application.usecases.UpdateUserUseCaseImpl;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;
import com.ohmytyche.core.user.infrastructure.mapper.UserMapper;
import com.ohmytyche.core.user.infrastructure.repositories.JpaUserRepository;
import com.ohmytyche.core.user.infrastructure.repositories.JpaUserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Configuration class for User-related beans in the application.
 */
@Configuration
public class UserConfig {

    @Bean
    public UserService userService(final UserRepositoryPort userRepositoryPort) {
        return new UserServiceImpl(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new RetrieveUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(final JpaUserRepository jpaUserRepository, final UserMapper userMapper) {
        return new JpaUserRepositoryAdapter(jpaUserRepository, userMapper);
    }

    @Bean
    public UserMapper userMapper(final @Lazy AbstractEntityMapper<AccountEntity, Account> accountMapper) {
        return new UserMapper(accountMapper);
    }
}
