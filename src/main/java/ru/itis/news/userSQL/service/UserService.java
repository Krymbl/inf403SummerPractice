package ru.itis.news.userSQL.service;

import ru.itis.news.userSQL.dto.UserSQLDto;
import ru.itis.news.userSQL.entity.UserSQL;
import ru.itis.news.userSQL.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final int MIN_PASSWORD_LENGTH = 7;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(String username, String password) {

        validatePassword(password);

        UserSQL userSQL = new UserSQL(username, password);

        userRepository.save(userSQL);
    }

    public List<UserSQLDto> getUsers() {

        return userRepository.findAll().stream()
                .map(user -> new UserSQLDto(user.getId(), user.getUsername()))
                .toList();

    }

    public void updatePassword(Integer id, String newPassword) {
        UserSQL userSQL = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found!"));

        validatePassword(newPassword);
        userSQL.setPassword(newPassword);
        userRepository.update(userSQL);

    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password must be at least 7 characters");
        }
    }


}
