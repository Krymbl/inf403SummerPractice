package ru.itis.news.userSQL.dto;

public class UserSQLDto {

    private final Integer id;
    private final String username;

    public UserSQLDto(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
