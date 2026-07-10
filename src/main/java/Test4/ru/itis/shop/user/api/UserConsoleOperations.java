package Test4.ru.itis.shop.user.api;

import Test4.ru.itis.shop.user.application.UserService;
import Test4.ru.itis.shop.user.domain.User;

import java.util.List;
import java.util.Scanner;

public class UserConsoleOperations {

    UserService userService;
    private final Scanner scanner;

    public UserConsoleOperations(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        printUserMenu();

        String command = scanner.nextLine();

        switch (command) {
            case "1": {
                signUp();
            }
            break;
            case "2": {
                signIn();
            }
            break;
            case "4": {
                updateProfileDescription();
            }
            break;
            case "5": {
                showAllUsers();
            }
            break;
            case "0": {
                System.exit(0);
            }
        }
    }

    private static void printUserMenu() {
        System.out.println("1. Регистрация пользователя");
        System.out.println("2. Вход в систему");
        System.out.println("3. Найти пользователя по id");
        System.out.println("4. Обновить данные пользователя");
        System.out.println("5. Показать всех пользователей");
        System.out.println("0. Выход");
    }

    private void signUp() {
        System.out.println("Сейчас будем регистрировать пользователя");
        System.out.println("Введите email:");
        String email = scanner.nextLine();
        System.out.println("Введите password:");
        String password = scanner.nextLine();
        System.out.println("Введите описание профиля:");
        String profileDescription = scanner.nextLine();

        userService.signUp(email, password, profileDescription);
    }


    private void signIn() {
        System.out.println("Вы можете войти в приложение");
        System.out.println("Введите email:");
        String email = scanner.nextLine();
        System.out.println("Введите password:");
        String password = scanner.nextLine();

        if (userService.signIn(email, password)) {
            System.out.println("Вы вошли в приложение");
        } else {
            System.out.println("Email или пароль не верны");
        }
    }

    private void updateProfileDescription() {
        System.out.println("Введите email пользователя, данные которого хотите обновить:");
        String email = scanner.nextLine();

        if (!userService.userExists(email)) {
            System.out.println("Пользователь с таким email не найден");
            return;
        }

        System.out.println("Пользователь найден. Введите новое описание профиля:");
        String newProfileDescription = scanner.nextLine();

        boolean updated = userService.updateProfileDescription(email, newProfileDescription);

        if (updated) {
            System.out.println("Данные пользователя успешно обновлены");
        } else {
            System.out.println("Не удалось обновить данные пользователя");
        }
    }

    private void showAllUsers() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("Пользователей нет");
            return;
        }

        for (User user : users) {
            System.out.println(user.getEmail() + " - " + user.getProfileDescription());
        }
    }

}
