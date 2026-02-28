package service;

import exception.InvalidLoginException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.HashMap;

public class AuthService {

    private HashMap<String, String> userDatabase;

    // Constructor → Load users from file
    public AuthService() {
        userDatabase = new HashMap<>();
        loadUsers();
    }

    // Load users from data/users.txt
    private void loadUsers() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("data/users.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length >= 2) {
                    String username = parts[0];
                    String password = parts[1];

                    userDatabase.put(username, password);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("User file not found!");
        }
    }

    // Login Method
    public boolean login(String username, String password)
            throws InvalidLoginException {

        if (userDatabase.containsKey(username)) {

            String storedPassword = userDatabase.get(username);

            if (storedPassword.equals(password)) {
                return true;
            } else {
                throw new InvalidLoginException("Wrong password!");
            }

        } else {
            throw new InvalidLoginException("User not found!");
        }
    }

    // Register New User
public void registerUser(String username, String password, String email) {

    try {

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("data/users.txt", true));

        bw.write(username + "," + password + "," + email);
        bw.newLine();
        bw.close();

        userDatabase.put(username, password);

        System.out.println("User registered successfully!");

    } catch (Exception e) {
        System.out.println("Registration file error!");
    }
}
}