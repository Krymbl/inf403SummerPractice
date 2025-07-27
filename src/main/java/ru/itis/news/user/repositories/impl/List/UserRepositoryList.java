package ru.itis.news.user.repositories.impl.List;

import ru.itis.news.user.entity.User;
import ru.itis.news.user.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryList implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findById(String uuid) {
        for (User user : users) {
            if (user.getUuid().equals(uuid)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}
