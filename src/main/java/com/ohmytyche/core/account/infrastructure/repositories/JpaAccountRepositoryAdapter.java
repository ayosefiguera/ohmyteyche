package com.ohmytyche.core.account.infrastructure.repositories;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.domain.ports.out.AccountRepositoryPort;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link AccountRepositoryPort} interface.
 */
@Component
public class JpaAccountRepositoryAdapter implements AccountRepositoryPort {

    private JpaAccountRepository jpaAccountRepository;
    private AbstractEntityMapper<AccountEntity, Account> accountEntityMapper;

    public JpaAccountRepositoryAdapter(final JpaAccountRepository jpaAccountRepository,
                                       final AbstractEntityMapper<AccountEntity, Account> accountEntityMapper) {
        setJpaAccountRepository(jpaAccountRepository);
        setAccountEntityMapper(accountEntityMapper);
    }

    @Override
    public Account save(final Account account) {
        final var accountEntity = getAccountEntityMapper().toEntity(account);
        final var accountEntitySaved = getJpaAccountRepository().save(accountEntity);
        return getAccountEntityMapper().toDomain(accountEntitySaved);
    }

    @Override
    public Optional<Account> findById(final Long id) {
        return getJpaAccountRepository().findById(id).map(getAccountEntityMapper()::toDomain);
    }

    @Override
    public List<Account> findAll() {
        return getJpaAccountRepository().findAll().stream()
                .map(getAccountEntityMapper()::toDomain)
                .toList();
    }

    @Override
    public Optional<Account> update(final Account account) {
        if (getJpaAccountRepository().existsById(account.getId())) {
            final var accountEntity = getAccountEntityMapper().toEntity(account);
            final var accountEntityUpdated = getJpaAccountRepository().save(accountEntity);
            return Optional.of(getAccountEntityMapper().toDomain(accountEntityUpdated));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final Long id) {
        if (getJpaAccountRepository().existsById(id)) {
            getJpaAccountRepository().deleteById(id);
            return true;
        }
        return false;
    }

    protected JpaAccountRepository getJpaAccountRepository() {
        return jpaAccountRepository;
    }

    public void setJpaAccountRepository(final JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    protected AbstractEntityMapper<AccountEntity, Account> getAccountEntityMapper() {
        return accountEntityMapper;
    }

    public void setAccountEntityMapper(final AbstractEntityMapper<AccountEntity, Account> accountEntityMapper) {
        this.accountEntityMapper = accountEntityMapper;
    }
}
