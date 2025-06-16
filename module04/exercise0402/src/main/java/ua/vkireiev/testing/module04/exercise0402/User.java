package ua.vkireiev.testing.module04.exercise0402;

public class User {
    private long id;
    private String username;
    private String password;
    private boolean lock = false;

    public User() {
    }

    public User(long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isLock() {
        return this.lock;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id
            + ", username=" + username
            + ", password=" + password
            + ", lock=" + lock
            + "]";
    }
}
