package ru.itis.news.app;

import ru.itis.news.userSQL.entity.UserSQL;
import ru.itis.news.userSQL.repositories.JdbcImpl.UserRepositoryJdbcImpl;
import ru.itis.news.userSQL.repositories.UserRepository;
import ru.itis.news.util.jdbc.SimpleDataSource;

import javax.sql.DataSource;

public class Main3 {
    public static void main(String[] args) {
        DataSource dataSource = new SimpleDataSource("jdbc:postgresql://localhost:5432/shop_db", "postgres", "qwerty007");
        UserRepository userRepository = new UserRepositoryJdbcImpl(dataSource);

//        UserSQL userSQL = new UserSQL("marsel12", "qwerty007");
//        userSQL.setAge(31);
//        userSQL.setEmail("sidikov@gmail.com");
//
//        userRepository.save(userSQL);

        System.out.println(userRepository.findAll());

    }
}
