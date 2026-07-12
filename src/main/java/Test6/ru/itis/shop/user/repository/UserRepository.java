package Test6.ru.itis.shop.user.repository;

import Test6.ru.itis.shop.user.api.dto.UserDto;
import Test6.ru.itis.shop.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findByEmail(String email);

    Optional<UserDto> findById(Integer id);

    void updateProfileDescriptionByEmail(String email, String profileDescription);

    List<UserDto> findAll();

    List<UserDto> findAllByProfileDescription(String profileDescription);
}