package ua.vkireiev.testing.module08.exercise0802.model;

import java.util.Objects;

/**
 * @author Viktor Kireiev
 */
public class Author {
    private Long id;
    private String name;

    public Author(String name) {
        super();
        this.name = name;
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

    @Override
    public String toString() {
        return "Author [id=" + this.id +
            ", name=" + this.name +
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
        Author other = (Author) obj;
        return Objects.equals(this.id, other.id);
    }
}
