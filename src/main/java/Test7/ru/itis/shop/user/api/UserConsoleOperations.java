package Test7.ru.itis.shop.user.api;

import Test7.ru.itis.shop.user.api.dto.UserDto;
import Test7.ru.itis.shop.user.application.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserConsoleOperations {

    private final UserService userService;
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
            case "3": {
                findById();
            }
            break;
            case "4": {
                updateProfileDescriptionByEmail();
            }
            break;
            case "5": {
                findAll();
            }
            break;
            case "6": {
                showUsersByProfileDescription();
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
        System.out.println("4. Обновить описание пользователя по почте");
        System.out.println("5. Получить информацию обо всех пользователях");
        System.out.println("6. Показать информацию о пользователях с заданным описанием профиля");
        System.out.println("0. Выход");
    }

    private void signUp() {
        System.out.println("Сейчас будем регистрировать пользователя");
        System.out.println("Введите name:");
        String name = scanner.nextLine();
        System.out.println("Введите email:");
        String email = scanner.nextLine();
        System.out.println("Введите password:");
        String password = scanner.nextLine();
        System.out.println("Введите описание профиля:");
        String profileDescription = scanner.nextLine();

        userService.signUp(name, email, password, profileDescription);
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

    private void findById() {
        System.out.println("Введите id:");
        Integer id = Integer.parseInt(scanner.nextLine());

        Optional<UserDto> userDto = userService.findById(id);

        if (userDto.isPresent()) {
            System.out.println(userDto.get());
        } else {
            System.out.println("Пользователь с таким id не найден");
        }
    }

    private void updateProfileDescriptionByEmail() {
        System.out.println("Введите email:");
        String email = scanner.nextLine();
        System.out.println("Введите новое описание профиля:");
        String profileDescription = scanner.nextLine();

        userService.updateProfileDescriptionByEmail(email, profileDescription);

        System.out.println("Описание профиля обновлено");
    }

    private void findAll() {
        List<UserDto> users = userService.findAll();
        System.out.println(users);
    }

    private void showUsersByProfileDescription() {
        System.out.println("Введите нужное описание:");
        String profileDescription = scanner.nextLine();

        List<UserDto> users = userService.findAllByProfileDescription(profileDescription);
        System.out.println(users);
    }

}