package com.ohmytyche.core.user.infrastructure.mapper;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.infrastructure.entities.UserEntity;

/**
 * Implementation of {@link AbstractEntityMapper} for {@link UserEntity} and {@link User}
 */
public class UserMapper extends AbstractEntityMapper<UserEntity, User> {

    private AbstractEntityMapper<AccountEntity, Account> AccountEntityMapper;

    public UserMapper(final AbstractEntityMapper<AccountEntity, Account> accountEntityMapper) {
        setAccountEntityMapper(accountEntityMapper);
    }

    @Override
    public UserEntity toEntity(final User domain) {
        var entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setUsername(domain.getUsername());
        entity.setEmail(domain.getEmail());
        entity.setUpdated(domain.getUpdated());
        entity.setCreated(domain.getCreated());
        entity.setAccounts(getAccountEntityMapper().toEntity(domain.getAccounts()));
        return entity;
    }

    @Override
    public User toDomain(final UserEntity entity) {
        var domain = new User();
        domain.setId(entity.getId());
        domain.setUsername(entity.getUsername());
        domain.setEmail(entity.getEmail());
        domain.setUpdated(entity.getUpdated());
        domain.setCreated(entity.getCreated());
        domain.setAccounts(getAccountEntityMapper().toDomain(entity.getAccounts()));
        return domain;
    }

    protected AbstractEntityMapper<AccountEntity, Account> getAccountEntityMapper() {
        return AccountEntityMapper;
    }

    public void setAccountEntityMapper(final AbstractEntityMapper<AccountEntity, Account> accountEntityMapper) {
        AccountEntityMapper = accountEntityMapper;
    }
}
