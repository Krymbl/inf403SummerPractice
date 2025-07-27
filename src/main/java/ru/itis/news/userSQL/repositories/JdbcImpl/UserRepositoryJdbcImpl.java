package ru.itis.news.userSQL.repositories.JdbcImpl;

import ru.itis.news.user.entity.User;
import ru.itis.news.userSQL.entity.UserSQL;
import ru.itis.news.userSQL.repositories.UserRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO Реализовать один класс `UserRepositoryJdbcImpl` HW_2
public class UserRepositoryJdbcImpl implements UserRepository {

    //language=SQL
    private final String SQL_SELECT_ALL = "select id, username, password, email, age from account";

    //language=SQL
    private final String SQL_INSERT = "insert into account(username, password, email, age) values (?, ?, ?, ?);";

    private final DataSource dataSource;

    public UserRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(UserSQL userSQL) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, userSQL.getUsername());
            preparedStatement.setString(2, userSQL.getPassword());
            preparedStatement.setString(3, userSQL.getEmail());
            preparedStatement.setInt(4, userSQL.getAge());

            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt("id");

                    userSQL.setId(id);
                } else {
                    throw new SQLException("Cannot obtain id from user");
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<UserSQL> findAll() {

        List<UserSQL> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {

            while (resultSet.next()) {
                UserSQL userSQL = new UserSQL(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"));

                users.add(userSQL);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return users;
    }

    @Override
    public void update(UserSQL userSQL) {

    }

    @Override
    public Optional<UserSQL> findById(Integer id) {
        return Optional.empty();
    }
}

/// конец
