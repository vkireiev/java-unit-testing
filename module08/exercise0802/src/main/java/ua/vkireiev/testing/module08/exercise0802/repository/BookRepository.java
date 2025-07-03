package ua.vkireiev.testing.module08.exercise0802.repository;

import ua.vkireiev.testing.module08.exercise0802.model.Book;

import java.util.*;

/**
 * @author Viktor Kireiev
 */
public class BookRepository implements Repository<Book, Long> {
    private static final Set<Book> elements = new HashSet<>();
    private static long count = 0;

    @Override
    public boolean exist(Book book) {
        return elements.stream()
            .anyMatch(b -> b.getName().equalsIgnoreCase(book.getName())
                || b.getIsbn().equalsIgnoreCase(book.getIsbn()));
    }

    @Override
    public Optional<Book> get(Long id) {
        return elements.stream()
            .filter(book -> book.getId() == id)
            .findFirst();
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(elements);
    }

    @Override
    public Book add(Book book) {
        if (!exist(book)) {
            book.setId(count++);
            elements.add(book);
        }

        return elements.stream()
            .filter(b -> b.getName().equalsIgnoreCase(book.getName())
                && b.getIsbn().equalsIgnoreCase(book.getIsbn()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    @Override
    public Optional<Book> update(Book book) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
    }
}
