package com.ohmytyche.core.user.infrastructure.repositories;

import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import com.ohmytyche.core.user.domain.models.User;
import com.ohmytyche.core.user.domain.ports.out.UserRepositoryPort;
import com.ohmytyche.core.user.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link UserRepositoryPort} interface.
 */
@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private JpaUserRepository jpaUserRepository;
    private AbstractEntityMapper<UserEntity, User> UserMapper;

    public JpaUserRepositoryAdapter(final JpaUserRepository jpaUserRepository,
                                    final AbstractEntityMapper<UserEntity, User> userMapper) {
        setJpaUserRepository(jpaUserRepository);
        setUserMapper(userMapper);
    }

    @Override
    public User save(final User user) {
        final var userEntity = getUserMapper().toEntity(user);
        final var userEntitySaved = getJpaUserRepository().save(userEntity);
        return getUserMapper().toDomain(userEntitySaved);
    }

    @Override
    public Optional<User> findById(final Long id) {
        return getJpaUserRepository().findById(id)
                .map(getUserMapper()::toDomain);
    }

    @Override
    public List<User> findAll() {
        return getJpaUserRepository().findAll().stream()
                .map(getUserMapper()::toDomain).toList();
    }

    @Override
    public Optional<User> update(final User user) {
        if (getJpaUserRepository().existsById(user.getId())) {
            final var userEntity = getUserMapper().toEntity(user);
            final var userEntityUpdated = getJpaUserRepository().save(userEntity);
            return Optional.of(getUserMapper().toDomain(userEntityUpdated));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final Long id) {
        if (getJpaUserRepository().existsById(id)) {
            getJpaUserRepository().deleteById(id);
            return true;
        }
        return false;
    }

    protected JpaUserRepository getJpaUserRepository() {
        return jpaUserRepository;
    }

    public void setJpaUserRepository(final JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    protected AbstractEntityMapper<UserEntity, User> getUserMapper() {
        return UserMapper;
    }

    public void setUserMapper(final AbstractEntityMapper<UserEntity, User> userMapper) {
        UserMapper = userMapper;
    }
}
