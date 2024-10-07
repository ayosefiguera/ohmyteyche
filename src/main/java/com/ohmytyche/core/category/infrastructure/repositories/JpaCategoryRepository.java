package com.ohmytyche.core.category.infrastructure.repositories;

import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository interface for performing CRUD operations on {@link CategoryEntity}
 */
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
