package ru.itis.news.userSQL.repositories;

import ru.itis.news.userSQL.entity.UserSQL;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(UserSQL usersSQL);

    List<UserSQL> findAll();

    void update(UserSQL userSQL);

    Optional<UserSQL> findById(Integer id);

}
