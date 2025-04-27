package com.demo.models;

public class RegistrationUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public RegistrationUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegistrationUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegistrationUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegistrationUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegistrationUser setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public String toString() {
        return "RegistrationUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}