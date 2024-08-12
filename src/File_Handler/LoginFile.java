package File_Handler;

import Users.Main;
import Users.User;

import java.io.*;
import java.util.Scanner;

public class LoginFile {

    public static void readLoginCredentials(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine() && Main.getNumUsers() < Main.getMaxUsers()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String role = parts[2].trim();

                    // Create a new User object and add to Main's users array
                    Main.getUsers()[Main.getNumUsers()] = new User(username, password, role);
                    Main.setNumUsers(Main.getNumUsers() + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public static void writeLoginCredentialsToFile(String username, String password, String role, String filename) {
        if (Main.getNumUsers() < Main.getMaxUsers()) {
            // Check if the username already exists
            if (findUserByUsername(username) == null) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
                    String userData = username + "," + password + "," + role;
                    writer.println(userData);

                    // Update Main class users array and numUsers
                    Main.getUsers()[Main.getNumUsers()] = new User(username, password, role);
                    Main.setNumUsers(Main.getNumUsers() + 1);

                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }
            } else {
                System.out.println("Username already exists. Please choose a different username.");
            }
        } else {
            System.out.println("Maximum number of users reached.");
        }
    }

    public static boolean checkLoginCredentials(String username, String password, String filename) {
        for (int i = 0; i < Main.getNumUsers(); i++) {
            if (Main.getUsers()[i].getUsername().equals(username) && Main.getUsers()[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static String getUserRole(String username, String password, String filename) {
        for (int i = 0; i < Main.getNumUsers(); i++) {
            if (Main.getUsers()[i].getUsername().equals(username) && Main.getUsers()[i].getPassword().equals(password)) {
                return Main.getUsers()[i].getRole();
            }
        }
        return null; // Role not found
    }

    private static User findUserByUsername(String username) {
        for (int i = 0; i < Main.getNumUsers(); i++) {
            if (Main.getUsers()[i] != null && Main.getUsers()[i].getUsername().equals(username)) {
                break;
            }
        }
        return null;
    }
}
