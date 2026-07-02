package Test2.ru.itis.shop.app;

import Test2.ru.itis.shop.user.api.UserConsoleOperations;
import Test2.ru.itis.shop.user.application.UserService;
import Test2.ru.itis.shop.user.infrastructure.persistence.UserFileRepository;
import Test2.ru.itis.shop.user.infrastructure.persistence.UserMapper;

public class Main {
    public static void main(String[] args) {
        UserFileRepository userFileRepository = new UserFileRepository("user.txt", new UserMapper());
        UserService userService = new UserService(userFileRepository);

        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}
