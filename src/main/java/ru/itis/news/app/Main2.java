package ru.itis.news.app;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop_db";
        String user = "postgres";
        String password = "qwerty007";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from account")){
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " "
                        + resultSet.getString("username") + " "
                        + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
