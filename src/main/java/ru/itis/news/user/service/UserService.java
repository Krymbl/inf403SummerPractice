package ru.itis.news.user.service;

import ru.itis.news.user.dto.UserDto;
import ru.itis.news.user.entity.User;
import ru.itis.news.user.repositories.UserRepository;

import java.util.List;
import java.util.function.Supplier;

public class UserService {

    private final int MIN_PASSWORD_LENGTH = 7;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(String username, String password) {

        validatePassword(password);

        User user = new User(username, password);

        userRepository.save(user);
    }

    public List<UserDto> getUsers() {

        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getUuid(), user.getUsername()))
                .toList();

    }

    public void updatePassword(String uuid, String newPassword) {
        User user = userRepository.findById(uuid).orElseThrow(
                () -> new IllegalArgumentException("User not found!"));

        validatePassword(newPassword);
        user.setPassword(newPassword);
        userRepository.update(user);

    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password must be at least 7 characters");
        }
    }


}
