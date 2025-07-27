package ru.itis.news.user.repositories.impl.file;

import ru.itis.news.user.entity.User;
import ru.itis.news.user.repositories.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryFile implements UserRepository {

    private final String fileName;

    public UserRepositoryFile(String fileName) {
        this.fileName = fileName;

    }
    @Override
    public void save(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            writer.write(UserFileUtil.toLine(user));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().map(line -> UserFileUtil.fromLine(line)).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                if (UserFileUtil.fromLine(line).getUuid().equals(user.getUuid())) {
                    lines.add(UserFileUtil.toLine(user));
                } else {
                    lines.add(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
                 e.printStackTrace();
        }
        System.out.println(lines);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findById(String uuid) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().filter(line -> UserFileUtil.fromLine(line).getUuid().equals(uuid))
                    .findFirst().map(line -> UserFileUtil.fromLine(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
