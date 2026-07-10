package Test4.ru.itis.shop.user.infrastructure.persistence;


import Test4.ru.itis.shop.user.domain.User;
import Test4.ru.itis.shop.user.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/newdata";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty";
    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, email, password, profile_description from person";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String profileDescription = resultSet.getString("profile_description");

                users.add(new User(id, email, password, profileDescription));
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return users;
    }
}

