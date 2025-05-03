package com.demo.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmailLogger {
    public static final String FILE_PATH = "src/test/resources/used_emails.csv";

    public static void log(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = firstName + "," + lastName + "," + email + "," + password + "," + passwordConfirmation;
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error logging email: " + email);
            e.printStackTrace();
        }
    }
}
