package ru.itis.shop.app;

import ru.itis.shop.console.Menu;
import ru.itis.shop.user.console.UserConsole;
import ru.itis.shop.user.repositories.UserRepository;
import ru.itis.shop.user.repositories.impl.List.UserRepositoryList;
import ru.itis.shop.user.repositories.impl.file.UserRepositoryFile;
import ru.itis.shop.user.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepositoryFile = new UserRepositoryFile("FileUsers.txt");
        UserRepository userRepositoryList = new UserRepositoryList();

        UserService userService = new UserService(userRepositoryFile);

        UserConsole userConsole = new UserConsole(userService);

        Menu menu = new Menu(userConsole);
        menu.run();
    }

}