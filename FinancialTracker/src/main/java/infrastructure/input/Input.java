package infrastructure.input;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);
    private static final int MAX_LENGTH = 64;

    public String read() {
        for (int i = 0; i < 3; i++) {
            boolean isValid = true;
            String input = scanner.nextLine();
            if (input.length() > MAX_LENGTH) {
                System.out.println("Ввод не может превышать" + MAX_LENGTH + "символа. Повторите ввод.");
                continue;
            }
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (!Character.toString(ch).matches("[\\w\\s.,!?;:/()&-€$£¥₽]")) {
                    System.out.println("Ошибка: символ '" + ch + "' является недопустимым. Повторите ввод.");
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return input;
            }
        }
        return "";
    }

    public double readDouble () {
        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.printf("Некорректный ввод. Повторите попытку: ");
            }
        }
        return 0.0;
    }
}


