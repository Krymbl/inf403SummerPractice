package ru.itis.shop.userSQL.console;

import ru.itis.shop.userSQL.dto.UserSQLDto;
import ru.itis.shop.userSQL.service.UserService;

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

    public void updatePasswword(String uuid, String newPassword) {
        try {
            userService.updatePassword(uuid, newPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
