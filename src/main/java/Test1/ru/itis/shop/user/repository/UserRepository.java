package Test1.ru.itis.shop.user.repository;

import Test1.ru.itis.shop.user.domain.User;

public interface UserRepository {

    void save(User user);

    User findById(String id);
}
