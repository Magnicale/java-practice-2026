package Test5.ru.itis.shop.app;

import Test5.ru.itis.shop.infrastructure.persistence.jdbc.DriverManagerDataSource;
import Test5.ru.itis.shop.user.api.UserConsoleOperations;
import Test5.ru.itis.shop.user.application.UserService;
import Test5.ru.itis.shop.user.infrastructure.persistence.jdbc.UserRepositoryJdbcImpl;
import Test5.ru.itis.shop.user.repository.UserRepository;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource  = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/shop_db",
                "postgres", "qwerty");

        UserRepository userRepository = new UserRepositoryJdbcImpl(dataSource);

        System.out.println(userRepository.findAll());
        UserService userService = new UserService(userRepository);

        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}
