package ua.vkireiev.testing.module08.exercise0802.service;

import ua.vkireiev.testing.module08.exercise0802.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Viktor Kireiev
 */
public interface Serviceable<T, V> {

    Optional<T> get(V id);

    List<T> getAll();

    T add(Book book);

    Optional<T> update(T book);

    void delete(V id);

}
