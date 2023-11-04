package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {

    private Map<String, String> users;

    public UserAuthentication() {
        users = new HashMap<>();
    }

    public void register(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            System.out.println("Registration successful for user: " + username);
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful for user: " + username);
            return true;
        } else {
            System.out.println("Login failed. Please check your username and password.");
            return false;
        }
    }

    public static void main(String[] args) {
        UserAuthentication userAuth = new UserAuthentication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.print("Enter a username: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Enter a password: ");
                    String registerPassword = scanner.nextLine();
                    userAuth.register(registerUsername, registerPassword);
                    break;

                case 2:
                    System.out.print("Enter your username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();
                    userAuth.login(loginUsername, loginPassword);
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

