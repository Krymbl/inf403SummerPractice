package ru.itis.shop.userSQL.repositories;

import ru.itis.shop.userSQL.entity.UserSQL;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(UserSQL userSQL);

    List<UserSQL> findAll();

    void update(UserSQL userSQL);

    Optional<UserSQL> findById(String uuid);
}
