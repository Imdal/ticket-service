package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.repository.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private User currentUser;

    UserService() {

    }

    public boolean signUp(String username, String password) {
        System.out.println("signup");
        return false;
    }

    public boolean signIn(String username, String password) {
        System.out.println("signin");
        return false;
    }

    public boolean signOut() {
        System.out.println("signout");
        return false;
    }

    public String describeAccount() {
        System.out.println("describeaccount");
        return "valami";
    }
}
