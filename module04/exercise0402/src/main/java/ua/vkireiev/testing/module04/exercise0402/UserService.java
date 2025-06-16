package ua.vkireiev.testing.module04.exercise0402;

import java.util.Collection;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public long count() {
        return userRepository.count();
    }

    public User get(Long id) {
        return userRepository.get(id);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public boolean add(User user) {
        return userRepository.add(user);
    }

    public boolean remove(User user) {
        return userRepository.remove(user);
    }

    public boolean removeById(Long id) {
        return userRepository.removeById(id);
    }

    public long countByLock(boolean lock) {
        return userRepository.countByLock(lock);
    }
}
