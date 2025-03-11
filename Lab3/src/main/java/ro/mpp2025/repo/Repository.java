package ro.mpp2025.repo;

import ro.mpp2025.domain.Entity;

import java.util.Optional;

public interface Repository<ID, E extends Entity<ID>> {
    Optional<E> save(E entity);

    Optional<E> delete(ID id);

    Optional<E> update(E entity);

    Iterable<E> findAll();

    Optional<E> findOne(ID id);
}
