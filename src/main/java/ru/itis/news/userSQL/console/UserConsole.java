package ru.itis.news.userSQL.console;

import ru.itis.news.userSQL.dto.UserSQLDto;
import ru.itis.news.userSQL.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserConsole {

    private final Scanner scanner;
    private final UserService userService;

    public UserConsole(UserService userService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
    }

    public void signUp() {
        System.out.println("Введите данные пользователя для регистрации: ");
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        try {
            userService.signUp(username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void printUsers() {
        List<UserSQLDto> users = userService.getUsers();

        for (UserSQLDto user : users) {
            System.out.println(user.getId() + "|" + user.getUsername());
        }
    }

    public void updatePasswword(Integer id, String newPassword) {
        try {
            userService.updatePassword(id, newPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
