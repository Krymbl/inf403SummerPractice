package ru.itis.shop.services;

import ru.itis.shop.dto.UserDto;
import ru.itis.shop.entities.User;
import ru.itis.shop.repositories.UserRepositoryList;

import java.util.List;

public class UserService {

    private final int MIN_PASSWORD_LENGTH = 7;
    private final UserRepositoryList userRepositoryList;

    public UserService() {
        this.userRepositoryList = new UserRepositoryList();
    }

    public void signUp(String username, String password) {

        validatePassword(password);

        User user = new User(username, password);

        userRepositoryList.save(user);
    }

    public List<UserDto> getUsers() {

        return userRepositoryList.findAll().stream()
                .map(user -> new UserDto(user.getUuid(), user.getUsername()))
                .toList();

    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password must be at least 7 characters");
        }
    }


}
