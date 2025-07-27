package ru.itis.shop.console;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private UserConsole userConsole;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.userConsole = new UserConsole();
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
