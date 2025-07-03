package ua.vkireiev.testing.module08.exercise0802.repository;

import ua.vkireiev.testing.module08.exercise0802.model.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author Viktor Kireiev
 */
public class AuthorRepository implements Repository<Author, Long> {

    @Override
    public boolean exist(Author author) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<Author> get(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Author> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Author add(Author author) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Author> update(Author author) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
    }
}
