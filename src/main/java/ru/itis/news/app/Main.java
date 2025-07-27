package ru.itis.news.app;

import ru.itis.news.console.Menu;
import ru.itis.news.user.console.UserConsole;
import ru.itis.news.user.repositories.UserRepository;
import ru.itis.news.user.repositories.impl.file.UserRepositoryFile;
import ru.itis.news.user.repositories.impl.List.UserRepositoryList;
import ru.itis.news.user.service.UserService;

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