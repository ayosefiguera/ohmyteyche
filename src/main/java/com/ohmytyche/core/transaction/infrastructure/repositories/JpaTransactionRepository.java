package com.ohmytyche.core.transaction.infrastructure.repositories;

import com.ohmytyche.core.transaction.infrastructure.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository interface for performing CRUD operations on {@link TransactionEntity}.
 */
public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
