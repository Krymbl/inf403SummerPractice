package ru.itis.news.console;

import ru.itis.news.user.console.UserConsole;
import ru.itis.news.user.service.UserService;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private UserConsole userConsole;

    public Menu(UserConsole userConsole) {
        this.scanner = new Scanner(System.in);
        this.userConsole = userConsole;
    }

    public void run() {

        while (true) {

            printMenu();

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    userConsole.signUp();
                    break;
                case "2":
                    userConsole.printUsers();
                    break;
                case "3":
                    userConsole.printUsers();
                    System.out.println("Введите айди пользователя и пароль");
                    Scanner scanner = new Scanner(System.in);
                    String uuid =  scanner.nextLine();
                    String password = scanner.nextLine();
                    userConsole.updatePasswword(uuid, password);
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }

    private static void printMenu() {
        System.out.println("Работа с пользователями \n" +
                "1. Регистрация \n" +
                "2. Список всех пользователей \n" +
                "3. Обновить пароль \n" +
                "0. Завершение работы");
    }
}
