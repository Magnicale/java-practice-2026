package Test7.ru.itis.shop.app;

import Test7.ru.itis.shop.jdbc.DriverManagerDataSource;
import Test7.ru.itis.shop.user.api.UserConsoleOperations;
import Test7.ru.itis.shop.user.application.UserService;
import Test7.ru.itis.shop.user.infrastructure.persistence.jdbc.UserRepositoryJdbcImpl;
import Test7.ru.itis.shop.user.repository.UserRepository;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        DataSource dataSource = new DriverManagerDataSource(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));

        UserRepository userRepository = new UserRepositoryJdbcImpl(dataSource);

        System.out.println(userRepository.findAll());
        UserService userService = new UserService(userRepository);

        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}