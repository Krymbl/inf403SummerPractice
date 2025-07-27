package ru.itis.shop.userSQL.entity;

public class UserSQL {
    private Integer id;
    private final String username;
    private String password;
    private String email;
    private Integer age;

    public UserSQL(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserSQL(Integer id, String username, String password,String email, Integer age) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public void setUuid(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer geId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserSQL{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
