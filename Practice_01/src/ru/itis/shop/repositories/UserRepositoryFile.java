package ru.itis.shop.repositories;

import ru.itis.shop.entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryFile {

    private final String fileName;

    public UserRepositoryFile(String fileName) {
        this.fileName = fileName;

    }
    public void save(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            writer.write(user.getUuid() + "|" + user.getUsername() + "|" + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().map(line -> {
                String[] parts = line.split("\\|");
                return new User(parts[0], parts[1], parts[2]);
            }).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
