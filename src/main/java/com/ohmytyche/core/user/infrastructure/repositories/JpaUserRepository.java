package com.ohmytyche.core.user.infrastructure.repositories;

import com.ohmytyche.core.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository interface for performing CRUD operations on {@link UserEntity}.
 */
@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

}
