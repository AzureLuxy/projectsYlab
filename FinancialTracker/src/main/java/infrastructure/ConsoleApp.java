package infrastructure;

import domain.User;
import infrastructure.input.Input;
import infrastructure.input.Menu;
import infrastructure.data.DataStorage;
import infrastructure.output.Output;
import usecases.AuthService;
import usecases.Auch;
import usecases.TransactionImp;
import usecases.TransactionService;

import static infrastructure.input.Menu.MenuState.*;


public class ConsoleApp {
    private final Input input;
    private final Output output;
    private final DataStorage data;
    private final AuthService authService;
    private final TransactionService trnService;

    public ConsoleApp(Input input, Output output, DataStorage data, AuthService authService, TransactionService trnService) {
        this.input = input;
        this.output = output;
        this.data = data;
        this.authService = authService;
        this.trnService = trnService;
    }

    public static void main(String[] args) {
        Menu.MenuState currentState = LOGIN_MENU;
        ConsoleApp consoleApp = new ConsoleApp(new Input(), new Output(), new DataStorage(), new Auch(), new TransactionImp());

        consoleApp.output.println("Добро пожаловать в финансовый трекер!");
        consoleApp.output.println("Чтобы выбрать нужный пункт меню, введите номер варианта.");

        while (true) {
            if (currentState == LOGIN_MENU) {
                currentState = consoleApp.loginMenu();
            } else if (currentState == MAIN_MENU) {
                currentState = consoleApp.mainMenu();
            } else if (currentState == TRANSACTIONS_MENU) {
                currentState = consoleApp.transactionsMenu();
            } else if (currentState == START_MENU) {
                currentState = consoleApp.startMenu();
            } else if (currentState == EXIT) {
                consoleApp.output.println("Выход из программы...");
                break;
            }
        }
    }

    public Menu.MenuState loginMenu() {
        output.println("Меню входа:");
        output.println("1) Вход в систему");
        output.println("2) Регистрация нового пользователя");
        output.println("0) Выход из приложения");
        switch (input.read()) {
            case "0":
                return EXIT;
            case "1":
                if (authService.login(input, output, data)) {
                    output.println("Вы авторизованы");
                }
                if (User.getCurrentUser() !=null) {
                    return (User.getCurrentUser().getMonthlybudget() == 0.0) ? START_MENU: MAIN_MENU;
                } else {
                    output.println("Авторизация не удалась. Возврат на предыдущее меню");
                }
                break;
            case "2":
                if (authService.register(input, output, data)) {
                    output.println("Регистрация успешна! Произведите вход в систему.");
                } else {
                    output.println("Регистрация не удалась. Возврат на предыдущее меню.");
                }
                break;
            case "":
                break;
        }
        return LOGIN_MENU;
    }

    Menu.MenuState startMenu () {
        output.println("Стартовое меню:");
        output.println("Для работы с трекером нужно указать месячный бюджет. Также вы можете создать цель накоплений.");
        output.println("1) Задать месячный бюджет");
        if (User.getCurrentUser().getSavingsGoal() == null) {
            output.println("2) Создать цель");
        } else {
            output.println("2) Изменить цель");
        }
        output.println("3) Редактировать профиль");
        output.println("4) Выйти в меню логина");
        output.println("0) Закрыть программу");

        switch (input.read()) {
            case "0":
                return EXIT;
            case "1":
                return (trnService.setBudget(input, output)) ? MAIN_MENU:START_MENU;
            case "2":
            case "3":
            case "4":
                User.setCurrentUser(null);
                return LOGIN_MENU;
            case "":
        }
        return START_MENU;
    }

    Menu.MenuState mainMenu() {
        output.println("Главное меню:");
        output.println("1) Добавить доход или расход");
        output.println("2) Запросить список операций");
        output.println("3) Изменить месячный бюджет");
        if (User.getCurrentUser().getSavingsGoal() == null) {
            output.println("4) Создать цель");
        } else {
            output.println("4) Изменить цель");
        }
        output.println("5) Редактировать профиль");
        output.println("6) Выйти в меню логина");
        output.println("0) Закрыть программу");
        String choise = input.read().trim();
        switch (choise) {
            case "0":
                return EXIT;
            case "1":
                output.println("Случай 1");
                break;
            case "2":
                output.println("Случай 2");
                break;
            case "3":
                trnService.setBudget(input, output);
                break;
            case "4":
                output.println("Случай 3");
                break;
            case "5":
                output.println("Случай 4");
                break;
            case "6":
                output.println("Случай 5");
                break;
            case "":
        }
        return MAIN_MENU;
    }
    Menu.MenuState transactionsMenu (){
        return TRANSACTIONS_MENU;
    }

}
