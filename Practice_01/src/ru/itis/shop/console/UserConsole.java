package ru.itis.shop.console;

import ru.itis.shop.dto.UserDto;
import ru.itis.shop.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserConsole {

    private final Scanner scanner;
    private final UserService userService;

    public UserConsole() {
        this.scanner = new Scanner(System.in);
        this.userService = new UserService();
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
        List<UserDto> users = userService.getUsers();

        for (UserDto user : users) {
            System.out.println(user.getUuid() + "|" + user.getUsername());
        }
    }

}
