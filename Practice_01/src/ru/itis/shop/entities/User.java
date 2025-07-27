package ru.itis.shop.entities;

public class User {
    private final String username;
    private String password;
    private String uuid;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String uuid, String username, String password) {
        this.uuid = uuid;
        this.password = password;
        this.username = username;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
