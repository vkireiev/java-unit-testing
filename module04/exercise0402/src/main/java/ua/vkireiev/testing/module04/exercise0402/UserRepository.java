package ua.vkireiev.testing.module04.exercise0402;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepository implements Repository<User, Long> {
    private static final List<User> USERS = new ArrayList<>();

    private UserRepository() {
    }

    @Override
    public long count() {
        return USERS.size();
    }

    @Override
    public User get(Long id) {
        return USERS.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Collection<User> getAll() {
        return new ArrayList<>(USERS);
    }

    @Override
    public boolean add(User user) {
        return USERS.add(user);
    }

    @Override
    public boolean remove(User user) {
        return USERS.remove(user);
    }

    @Override
    public boolean removeById(Long id) {
        return USERS.removeIf(user -> user.getId() == id);
    }

    public long countByLock(boolean lock) {
        return USERS.stream()
            .filter(user -> user.isLock() == lock)
            .count();
    }

    public void clear() {
        USERS.clear();
    }
}
