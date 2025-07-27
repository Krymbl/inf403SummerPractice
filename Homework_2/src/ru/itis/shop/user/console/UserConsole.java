package ru.itis.shop.user.console;

import ru.itis.shop.user.dto.UserDto;
import ru.itis.shop.user.service.UserService;

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
        List<UserDto> users = userService.getUsers();

        for (UserDto user : users) {
            System.out.println(user.getUuid() + "|" + user.getUsername());
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
