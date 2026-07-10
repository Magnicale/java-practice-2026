package Test4.ru.itis.shop.app;

import Test4.ru.itis.shop.user.api.UserConsoleOperations;
import Test4.ru.itis.shop.user.application.UserService;
import Test4.ru.itis.shop.user.repository.UserRepository;
import Test4.ru.itis.shop.user.infrastructure.persistence.UserRepositoryJdbcImpl;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryJdbcImpl();
        UserService userService = new UserService(userRepository);

        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}
