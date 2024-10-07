package com.ohmytyche.core.account.infrastructure.mapper;

import com.ohmytyche.core.account.domain.models.Account;
import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.infrastructure.entities.UserEntity;

/**
 * Implementation of {@link AbstractEntityMapper} for {@link AccountEntity} and {@link Account}
 */
public class AccountMapper extends AbstractEntityMapper<AccountEntity, Account> {

    private AbstractEntityMapper<UserEntity, User> userMapper;

    public AccountMapper(final AbstractEntityMapper<UserEntity, User> userMapper) {
        setUserMapper(userMapper);
    }

    public AccountEntity toEntity(final Account domain) {

        var entity = new AccountEntity();
        entity.setId(domain.getId());
        entity.setAlias(domain.getAlias());
        entity.setBalance(domain.getBalance());
        entity.setCreated(domain.getCreatedDate());
        entity.setUpdated(domain.getUpdatedDate());
        entity.setUsers(getUserMapper().toEntity(domain.getUsers()));
        return entity;
    }

    public Account toDomain(final AccountEntity entity) {
        var domain = new Account();
        domain.setId(entity.getId());
        domain.setAlias(entity.getAlias());
        domain.setBalance(entity.getBalance());
        domain.setCreatedDate(entity.getCreated());
        domain.setUpdatedDate(entity.getUpdated());
        domain.setUsers(getUserMapper().toDomain(entity.getUsers()));
        return domain;
    }

    protected AbstractEntityMapper<UserEntity, User> getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(final AbstractEntityMapper<UserEntity, User> userMapper) {
        this.userMapper = userMapper;
    }
}
