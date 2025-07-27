package ru.itis.shop.dto;

public class UserDto {

    private final String uuid;
    private final String username;

    public UserDto(String uuid, String username) {
        this.uuid = uuid;
        this.username = username;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }
}
