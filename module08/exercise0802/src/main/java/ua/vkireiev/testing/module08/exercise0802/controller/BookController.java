package ua.vkireiev.testing.module08.exercise0802.controller;

import ua.vkireiev.testing.module08.exercise0802.model.Book;
import ua.vkireiev.testing.module08.exercise0802.service.BookService;
import ua.vkireiev.testing.module08.exercise0802.service.Serviceable;

/**
 * @author Viktor Kireiev
 */
public class BookController {
    private final Serviceable<Book, Long> bookService;

    public BookController() {
        super();
        this.bookService = new BookService();
    }

    public void printById(long id) {
        System.out.println(bookService.get(id));
    }

    public void run() {
        bookService.add(new Book("Book #1", "1-1-1-1"));
        bookService.add(new Book("Book #2", "1-1-1-2"));
        bookService.add(new Book("Book #3", "1-1-1-3"));

        bookService.getAll()
            .forEach(System.out::println);
    }
}
