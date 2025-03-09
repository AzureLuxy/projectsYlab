package usecases;

import domain.User;
import infrastructure.data.DataStorage;
import infrastructure.input.Input;
import infrastructure.output.Output;

public class Auch implements AuthService {

    @Override
    public boolean login(Input input, Output output, DataStorage data) {
        output.println("Введите email пользователя: ");
        String email = input.read();
        output.println("Введите пароль пользователя: ");
        String password = input.read();
        if (data.authentication(email, password)) {
            User.setCurrentUser(data.getUser(email));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(Input input, Output output, DataStorage data) {
        output.println("Введите email пользователя: ");
        String email = input.read();
        output.println("Введите пароль пользователя: ");
        String password = input.read();
        output.println("Введите имя пользователя: ");
        String name = input.read();
        User newUser = new User(email, password, name);
        data.createUser(newUser);

        return true;
    }
}
