package Test1.ru.itis.shop.user.infrastructure.persistence;

import Test1.ru.itis.shop.user.repository.UserRepository;
import Test1.ru.itis.shop.user.domain.User;
import Test1.ru.itis.shop.user.repository.UserRepository;

public class UserDatabaseRepository implements UserRepository {

    @Override
    public void save(User user) {
        System.out.println("Сохраняем в базу данных...");
    }

    @Override
    public User findById(String id) {
        System.out.println("Получаем из базы данных...");
        return null;
    }
}
