package ua.vkireiev.testing.module08.exercise0803.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * @author Viktor Kireiev
 */
public final class User {
    private final long id;
    private final String username;
    private final String password;
    private final boolean active;
    private final Set<String> keys;

    public User(long id, String username, String password, boolean active, Set<String> keys) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.keys = Collections.unmodifiableSet(keys);
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isActive() {
        return this.active;
    }

    public Collection<String> getKeys() {
        return this.keys;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id +
            ", username=" + this.username +
            ", password=" + this.password +
            ", active=" + this.active +
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
        User other = (User) obj;
        return this.id == other.id;
    }
}
