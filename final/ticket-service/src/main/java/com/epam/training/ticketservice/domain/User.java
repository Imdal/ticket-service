package com.epam.training.ticketservice.domain;

public class User {
    private String username;
    private String password;
    private String accountType;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accountType = "User";
    }

    public boolean signUp(String username, String password) {
        return true;

    }

    public String getUsername() {
        return username;
    }

    public String getAccountType() {
        return accountType;
    }
}
