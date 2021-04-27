package com.epam.training.ticketservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserProjection {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;

    private String password;
    private String accountType;

    public UserProjection(String username, String password) {
        this.username=username;
        this.password=password;
        this.accountType="User";
    }

    public  UserProjection() {}

    public String getUsername() {
        return username;
    }

    public String getAccountType() {
        return accountType;
    }
}
