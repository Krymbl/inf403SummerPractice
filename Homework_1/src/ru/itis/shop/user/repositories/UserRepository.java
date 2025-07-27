package ru.itis.shop.user.repositories;

import ru.itis.shop.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    void update(User user);

    Optional<User> findById(String uuid);
}
