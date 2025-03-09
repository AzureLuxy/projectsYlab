package infrastructure.data;

import domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataStorage {
    private final Map<String, User> users;

    public DataStorage() {
        this.users = new HashMap<>();
        users.put("default@mail.ru", new User("default@mail.ru", "default", "DefaultName"));
        users.put("admin@admin.com", new User("admin@admin.com", "admin", "admin"));
    }

    public boolean authentication (String login, String password) {
        User user = users.get(login);
        if (user == null) {
            return false;
        }
        if (Objects.equals(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public User getUser (String login) {
        return users.get(login);
    }

    public void createUser(User user) {
        users.put(user.getEmail(), user);
    }
}
