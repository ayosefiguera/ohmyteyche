package com.ohmytyche.core.account.infrastructure.repositories;

import com.ohmytyche.core.account.infrastructure.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository interface for performing CRUD operations on {@link AccountEntity}.
 */
@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, Long> {

}
