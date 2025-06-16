package ua.vkireiev.testing.module04.exercise0402;

import java.util.Collection;

public interface Repository<T, V> {
    long count();

    T get(V id);

    Collection<User> getAll();

    boolean add(T t);

    boolean remove(T t);

    boolean removeById(V id);
}
