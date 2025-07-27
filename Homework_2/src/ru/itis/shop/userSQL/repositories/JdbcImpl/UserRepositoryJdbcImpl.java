package ru.itis.shop.userSQL.repositories.JdbcImpl;

import ru.itis.shop.userSQL.entity.UserSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// TODO Реализовать один класс `UserRepositoryJdbcImpl` HW_2
public class UserRepositoryJdbcImpl {

    private Connection connection;

    public UserRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<UserSQL> findAll() {
        List<UserSQL> usersSQL = new ArrayList<>();
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account")){

            while (resultSet.next()) {
                usersSQL.add(new UserSQL(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersSQL;
    }
}

/// конец
