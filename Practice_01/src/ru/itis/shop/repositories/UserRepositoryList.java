package ru.itis.shop.repositories;

import ru.itis.shop.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryList {

    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }

}
