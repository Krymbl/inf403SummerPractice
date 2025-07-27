package ru.itis.news.app;

import ru.itis.news.userSQL.repositories.JdbcImpl.UserRepositoryJdbcImpl;
import ru.itis.news.userSQL.repositories.UserRepository;
import ru.itis.news.util.jdbc.SimpleDataSource;

import javax.sql.DataSource;

public class Main3 {
    public static void main(String[] args) {
        DataSource dataSource = new S
        UserRepository userRepository = new UserRepositoryJdbcImpl();

    }
}
