package ua.vkireiev.testing.module08.exercise0802.service;

import ua.vkireiev.testing.module08.exercise0802.annotation.MyCustomAnnotation;
import ua.vkireiev.testing.module08.exercise0802.model.Book;
import ua.vkireiev.testing.module08.exercise0802.repository.BookRepository;
import ua.vkireiev.testing.module08.exercise0802.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Viktor Kireiev
 */
public class BookService implements Serviceable<Book, Long> {
    private final Repository<Book, Long> bookRepository = new BookRepository();

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.get(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book add(Book book) {
        return bookRepository.add(book);
    }

    @Override
    public Optional<Book> update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    @MyCustomAnnotation
    public void custom() {
        System.out.println("Test...");
    }
}
