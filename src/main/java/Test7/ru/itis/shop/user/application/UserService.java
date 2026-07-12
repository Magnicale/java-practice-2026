package Test7.ru.itis.shop.user.application;

import Test7.ru.itis.shop.user.api.dto.UserDto;
import Test7.ru.itis.shop.user.domain.User;
import Test7.ru.itis.shop.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(String name, String email, String password, String profileDescription) {
        User user = new User(name, email, password, profileDescription);
        userRepository.save(user);
    }

    public boolean signIn(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            return userOptional.get().getPassword().trim().equals(password);
        } else return false;
    }

    public Optional<UserDto> findById(Integer id) {
        return userRepository.findById(id);
    }

    public void updateProfileDescriptionByEmail(String email, String profileDescription) {
        userRepository.updateProfileDescriptionByEmail(email, profileDescription);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    public List<UserDto> findAllByProfileDescription(String profileDescription) {
        return userRepository.findAllByProfileDescription(profileDescription);
    }
}