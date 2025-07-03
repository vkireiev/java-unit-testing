package ua.vkireiev.testing.module08.exercise0802.repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Viktor Kireiev
 */
public interface Repository<T, V> {

    boolean exist(T t);

    Optional<T> get(V id);

    List<T> getAll();

    T add(T t);

    Optional<T> update(T t);

    void delete(V id);
}
