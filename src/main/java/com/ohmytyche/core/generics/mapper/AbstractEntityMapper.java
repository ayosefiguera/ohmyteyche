package com.ohmytyche.core.generics.mapper;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Abstract mapper class for converting between entity and domain models.
 *
 * @param <E> The entity type
 * @param <D> The domain model type
 */
public abstract class AbstractEntityMapper<E, D> {

    public abstract E toEntity(final D domain);

    public abstract D toDomain(final E entity);

    public Set<D> toDomain(final Set<E> entities) {
        return entities.stream().map(this::toDomain).collect(Collectors.toSet());
    }

    public Set<E> toEntity(final Set<D> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toSet());
    }
}
