package ua.vkireiev.testing.module08.exercise0802.model;

import java.util.Objects;

/**
 * @author Viktor Kireiev
 */
public class Book {
    private Long id;
    private String name;
    private String isbn;

    public Book(String name, String isbn) {
        super();
        this.name = name;
        this.isbn = isbn;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book [id=" + this.id +
            ", name=" + this.name +
            ", isbn=" + this.isbn +
            "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(this.id, other.id);
    }
}
